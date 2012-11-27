package org.personal.mason.pbandroid.domain;

/**
 * @author mmei
 */
public class Product {

private String id;
private ProductCategory productCategory;
private String productName;
private String shortDesc;
private String description;

public ProductCategory getProductCategory() {
	return productCategory;
}

public void setProductCategory(ProductCategory productCategory) {
	this.productCategory = productCategory;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getShortDesc() {
	return shortDesc;
}

public void setShortDesc(String shortDesc) {
	this.shortDesc = shortDesc;
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
