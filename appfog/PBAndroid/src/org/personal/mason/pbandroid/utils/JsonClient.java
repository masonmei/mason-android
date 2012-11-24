package org.personal.mason.pbandroid.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

public class JsonClient {
private DefaultHttpClient httpClient;
private HttpContext context;

public JsonClient(ClientConnectionManager conman, HttpParams params) {
	httpClient = new DefaultHttpClient(conman, params);
}

public JsonClient(HttpParams params) {
	httpClient = new DefaultHttpClient(params);
}

public JsonClient() {
	super();
}

public JSONObject getFromUrl(String url){
	
	return null;
}

public JSONObject postToUrl(String url, Object entity){
	return null;
}

public JSONObject putToUrl(String url, Object entity){
	return null;
}

public JSONObject deleteFromUrl(String url){
	return null;
}

private JSONObject executeRequest(HttpUriRequest request){
	try {
		HttpResponse response = httpClient.execute(request);
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode == 200){
			HttpEntity entity = response.getEntity();
			entity.getContentLength();
		}
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

}
