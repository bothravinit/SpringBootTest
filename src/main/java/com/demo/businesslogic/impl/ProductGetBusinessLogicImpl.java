package com.demo.businesslogic.impl;

import com.demo.businesslogic.ProductGetBusinessLogic;
import com.demo.dao.ProductDao;
import com.demo.entity.common.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : vinit.bothra
 * Date : 1/13/15-04:18.
 */
@Service
public class ProductGetBusinessLogicImpl implements ProductGetBusinessLogic {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProductsByCategoryId(String categoryId) {

		return productDao.findProductsByCategoryId(categoryId);
	}
}
