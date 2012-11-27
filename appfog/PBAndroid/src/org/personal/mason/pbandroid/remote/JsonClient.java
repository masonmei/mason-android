package org.personal.mason.pbandroid.remote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.personal.mason.pbandroid.cache.Cache;
import org.personal.mason.pbandroid.cache.DefaultCache;
import org.personal.mason.pbandroid.domain.Account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonClient {
private DefaultHttpClient httpClient;
private Cache<String, Object> cache;

private final String serverRoot;

public JsonClient(ClientConnectionManager conman, HttpParams params, String serverRoot) {
	httpClient = new DefaultHttpClient(conman, params);
	cache = new DefaultCache<String, Object>(20, TimeUnit.MINUTES);
	this.serverRoot = serverRoot;
}

public JsonClient(HttpParams params, String serverRoot) {
	this(null, params, serverRoot);
}

public JsonClient(String serverRoot) {
	this(null, serverRoot);
}

private void addCommonHeaders(HttpUriRequest request) {
	request.addHeader("Content-Type", "application/json");
	request.addHeader("Accept", "application/json");
	String token = getToken();
	if (token != null && !token.equals("")) {
		request.addHeader("Token", token);
	}
}

public void login() {
	String path = "account/validate";
	Account account = buildValidateAccount();
	HttpPost post = new HttpPost(serverRoot + path);
	StringEntity entity = buildEntity(account);
	if (entity != null) {
		post.setEntity(entity);
		executeRequest(post, true);
	}
}

public boolean checkLogin(){
	String token = getToken();
	if (token == null || token.equals("")) {
		return false;
	}
	return true;
}

private Account buildValidateAccount() {
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	return account;
}

private String getToken() {
	String token = (String) cache.get("Token");
	return token;
}

public StringEntity buildEntity(Object obj) {
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.registerTypeAdapter(Date.class, new DateJsonTypeAdapter());
	Gson gson = gsonBuilder.create();
	String jsonObj = gson.toJson(obj);
	try {
		StringEntity entity = new StringEntity(jsonObj, HTTP.UTF_8);
		entity.setContentType("application/json");
		return entity;
	} catch (UnsupportedEncodingException e) {
	}

	return null;
}

public String executeRequest(HttpUriRequest request) {
	if(!checkLogin()){
		login();
	}
	return executeRequest(request, false);
}

private String executeRequest(HttpUriRequest request, boolean readToken) {
	if (request == null) {
		throw new RuntimeException("request should never be null");
	}
	addCommonHeaders(request);
	try {
		HttpResponse response = httpClient.execute(request);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			if (readToken) {
				Header[] headers = response.getHeaders("Token");
				String token = headers.length > 0 ? headers[0].getValue() : null;
				cache.put("Token", token);
			}
			HttpEntity entity = response.getEntity();
			String value = entity.getContentType().getValue();
			System.out.println(value);
			String contentString = readStream(entity.getContent());
			return contentString;
		}
	} catch (ClientProtocolException e) {
	} catch (IOException e) {
	}
	return null;
}

private String readStream(InputStream stream) {
	if (stream == null) {
		return "";
	}
	StringBuilder builder = new StringBuilder();
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String line;
		while ((line = br.readLine()) != null) {
			builder.append(line);
		}
		return builder.toString();
	} catch (IOException e) {
	}
	return "";
}

}
