package com.demo.dao;

import com.demo.entity.common.Product;

import java.util.List;

/**
 * Author : vinit.bothra
 * Date : 1/13/15-04:44.
 */
public interface ProductDao {
	public List<Product> findProductsByCategoryId(String categoryId);
}
