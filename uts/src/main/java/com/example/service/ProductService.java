package com.example.service;

import java.util.List;

import com.example.model.ProductModel;

public interface ProductService {
	// viewall
	List<ProductModel> selectAllProducts();

	// view
	ProductModel selectProduct(int id);

	// update
	void updateProduct(ProductModel product);

	// add
	void addProduct(ProductModel product);
}
