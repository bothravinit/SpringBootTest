package com.demo.entity.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Author : vinit.bothra
 * Date : 1/12/15-02:27.
 */

/**
 * Dummy product definition
 */
@Getter
@Setter
public class Product {

	String sku;

	String title;

	String description;

	String categoryId;

	Integer price;

	public Product(String sku, String title, String description, String categoryId, Integer price) {
		this.sku = sku;
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
		this.price = price;
	}


}
