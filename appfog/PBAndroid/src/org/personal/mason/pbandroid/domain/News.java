package org.personal.mason.pbandroid.domain;

import java.util.Date;

/**
 * @author mmei
 */
public class News {
private String id;
private String title;
private Date date;
private String content;
private String description;

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getId() {
	return id;
}

public void setId(String id) {
	if (id.isEmpty()) {
		this.id = null;
	} else {
		this.id = id;
	}
}

}
