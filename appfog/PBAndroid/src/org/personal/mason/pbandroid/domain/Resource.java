package org.personal.mason.pbandroid.domain;

import java.util.Date;

/**
 * @author mmei
 */
public class Resource {

private String id;
private String resourcename;
private Date builddate;
private String description;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getResourcename() {
	return resourcename;
}

public void setResourcename(String resourcename) {
	this.resourcename = resourcename;
}

public Date getBuilddate() {
	return builddate;
}

public void setBuilddate(Date builddate) {
	this.builddate = builddate;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}