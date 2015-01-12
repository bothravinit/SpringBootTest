package com.demo;

import lombok.Getter;
import lombok.Setter;

/**
 * Author : vinit.bothra
 * Date : 1/12/15-02:27.
 */
@Getter
@Setter
public class Product {

	String baseSku;

	String title;

	String description;

	String categoryId;

	Integer price;

	Product() {}

	public Product(String baseSku, String title, String description, String categoryId, Integer price) {
		this.baseSku = baseSku;
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
		this.price = price;
	}


}
