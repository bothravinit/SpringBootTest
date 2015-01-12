package com.demo.dao.impl;

import com.demo.dao.ProductDao;
import com.demo.entity.common.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Author : vinit.bothra
 * Date : 1/13/15-04:46.
 */

/**
 * Dummy Implementation of ProductDao.
 * Thats the best thing in having interfaces :)
 * TODO : Have MySQL(or any DB) wiring here
 */
@Service
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findProductsByCategoryId(String categoryId) {

		Product product = new Product("name " + categoryId, "title " + categoryId, "description " + categoryId, categoryId, 123);
		return Arrays.asList(product);

	}
}
