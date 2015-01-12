package com.demo.businesslogic;

import com.demo.entity.common.Product;

import java.util.List;

/**
 * Author : vinit.bothra
 * Date : 1/13/15-04:18.
 */
public interface ProductGetBusinessLogic {
	List<Product> getProductsByCategoryId(String categoryId);
}
