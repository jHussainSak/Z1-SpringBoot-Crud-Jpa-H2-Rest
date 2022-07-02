package com.servertech.service;

import java.util.List;

import com.servertech.model.Product;


public interface ProductService {

	Product createProduct(Product product);

	Product updateProduct(Product product);

	Product updateProdctById(Product product,long id);

	List<Product> getAllProduct();

	Product getProductById(long id);

	void deleteProductById(long id);

}
