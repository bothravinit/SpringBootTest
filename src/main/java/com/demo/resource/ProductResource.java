package com.demo.resource;

import com.demo.businesslogic.ProductGetBusinessLogic;
import com.demo.entity.common.Product;
import com.demo.entity.request.ProductCreateRequest;
import com.demo.entity.response.ProductCreateResponse;
import com.demo.entity.response.ProductGetResponse;
import com.demo.entity.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author : vinit.bothra
 * Date : 1/13/15-02:47.
 */
@Controller
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductGetBusinessLogic productGetBusinessLogic;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	private BaseResponse getProductsByCategoryId(@RequestParam(value = "categoryId", required = false) String categoryId) {

		ProductGetResponse productGetResponse = new ProductGetResponse();

		productGetResponse.setProducts(productGetBusinessLogic.getProductsByCategoryId(categoryId));

		return productGetResponse;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	BaseResponse createProduct(@RequestBody ProductCreateRequest apiObject) {

		ProductCreateResponse productCreateResponse = new ProductCreateResponse();

		// TODO : Write business logic for creation here
		return productCreateResponse;
	}

}
