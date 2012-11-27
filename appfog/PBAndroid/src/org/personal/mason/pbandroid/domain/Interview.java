package org.personal.mason.pbandroid.domain;

import java.util.Date;

/**
 * @author mmei
 */
public class Interview {
private String id;
private String interviewName;
private Date date;
private String location;
private String notes;
private String contactInfo;

public String getInterviewName() {
	return interviewName;
}

public void setInterviewName(String interviewName) {
	this.interviewName = interviewName;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public String getContactInfo() {
	return contactInfo;
}

public void setContactInfo(String contactInfo) {
	this.contactInfo = contactInfo;
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
