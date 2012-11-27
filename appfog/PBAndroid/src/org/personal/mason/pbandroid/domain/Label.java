package org.personal.mason.pbandroid.domain;

/**
 * @author mmei
 */
public class Label {
private String id;
private String labelName;

public String getLabelName() {
	return labelName;
}

public void setLabelName(String labelName) {
	this.labelName = labelName;
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
