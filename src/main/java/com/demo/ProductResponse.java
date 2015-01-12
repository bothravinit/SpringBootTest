package com.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by vinit.bothra on 1/12/15.
 */

@Getter
@Setter
public class ProductResponse {
	List<Product> products;

	public ProductResponse() {
	}

	public ProductResponse(List<Product> products) {
		this.products = products;
	}
}
