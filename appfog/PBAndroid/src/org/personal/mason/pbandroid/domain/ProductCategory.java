package org.personal.mason.pbandroid.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmei
 */
public class ProductCategory {
private String id;
private boolean root;
private String categoryName;
private String description;
private List<ProductCategory> productCategories = new ArrayList<ProductCategory>();

public boolean isRoot() {
	return root;
}

public void setRoot(boolean root) {
	this.root = root;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<ProductCategory> getProductCategories() {
	return productCategories;
}

public void setProductCategories(List<ProductCategory> productCategories) {
	this.productCategories = productCategories;
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
