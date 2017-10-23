package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductMapper;
import com.example.model.ProductModel;

import lombok.extern.slf4j.*;

@Slf4j
@Service
public class ProductServiceDatabase implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	// viewall
	@Override
	public List<ProductModel> selectAllProducts() {
		log.info("select all products");
		return productMapper.selectAllProducts();
	}

	// view
	@Override
	public ProductModel selectProduct(int id) {
		log.info("select product with id {}", id);
		return productMapper.selectProduct(id);
	}

	// update
	@Override
	public void updateProduct(ProductModel product) {
		productMapper.updateProduct(product);
	}

	// add
	@Override
	public void addProduct(ProductModel product) {
		productMapper.addProduct(product);
	}
}