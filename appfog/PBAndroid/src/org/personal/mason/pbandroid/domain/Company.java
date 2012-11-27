package org.personal.mason.pbandroid.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmei
 */
public class Company {

private String id;
private String companyName;
private String province;
private String city;
private String businessType;
private Integer scale;
private String description;

private List<Label> labels = new ArrayList<Label>();
private List<News> newses = new ArrayList<News>();
private List<Product> products = new ArrayList<Product>();
private List<Job> jobs = new ArrayList<Job>();

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getProvince() {
	return province;
}

public void setProvince(String province) {
	this.province = province;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getBusinessType() {
	return businessType;
}

public void setBusinessType(String businessType) {
	this.businessType = businessType;
}

public Integer getScale() {
	return scale;
}

public void setScale(Integer scale) {
	this.scale = scale;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<Label> getLabels() {
	return labels;
}

public void setLabels(List<Label> labels) {
	this.labels = labels;
}

public List<News> getNewses() {
	return newses;
}

public void setNewses(List<News> newses) {
	this.newses = newses;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

public List<Job> getJobs() {
	return jobs;
}

public void setJobs(List<Job> jobs) {
	this.jobs = jobs;
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((businessType == null) ? 0 : businessType.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
	result = prime * result + ((labels == null) ? 0 : labels.hashCode());
	result = prime * result + ((newses == null) ? 0 : newses.hashCode());
	result = prime * result + ((products == null) ? 0 : products.hashCode());
	result = prime * result + ((province == null) ? 0 : province.hashCode());
	result = prime * result + ((scale == null) ? 0 : scale.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Company other = (Company) obj;
	if (businessType == null) {
		if (other.businessType != null)
			return false;
	} else if (!businessType.equals(other.businessType))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (companyName == null) {
		if (other.companyName != null)
			return false;
	} else if (!companyName.equals(other.companyName))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (jobs == null) {
		if (other.jobs != null)
			return false;
	} else if (!jobs.equals(other.jobs))
		return false;
	if (labels == null) {
		if (other.labels != null)
			return false;
	} else if (!labels.equals(other.labels))
		return false;
	if (newses == null) {
		if (other.newses != null)
			return false;
	} else if (!newses.equals(other.newses))
		return false;
	if (products == null) {
		if (other.products != null)
			return false;
	} else if (!products.equals(other.products))
		return false;
	if (province == null) {
		if (other.province != null)
			return false;
	} else if (!province.equals(other.province))
		return false;
	if (scale == null) {
		if (other.scale != null)
			return false;
	} else if (!scale.equals(other.scale))
		return false;
	return true;
}

}
