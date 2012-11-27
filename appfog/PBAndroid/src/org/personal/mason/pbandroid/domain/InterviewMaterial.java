package org.personal.mason.pbandroid.domain;

import java.util.Date;

/**
 * @author mmei
 */
public class InterviewMaterial {
private String id;
private int weight;
private String question;
private String answer;
private Date addDate;
private String type;

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}

public Date getAddDate() {
	return addDate;
}

public void setAddDate(Date addDate) {
	this.addDate = addDate;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
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
