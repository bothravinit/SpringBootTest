package com.demo.entity.response;

import com.demo.entity.common.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by vinit.bothra on 1/12/15.
 */

@Getter
@Setter
public class ProductGetResponse extends BaseResponse {
	List<Product> products;

	public ProductGetResponse() {
	}

	public ProductGetResponse(List<Product> products) {
		this.products = products;
	}
}
