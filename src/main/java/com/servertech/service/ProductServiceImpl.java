package com.servertech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servertech.exception.ResourceNotFoundException;
import com.servertech.model.Product;
import com.servertech.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDB=productRepository.findById(product.getId());
		if(productDB.isPresent()) {
			Product productUpdate=productDB.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;
		}
		throw new ResourceNotFoundException("Record Not Found for id : "+product.getId());
	}

	@Override
	public Product updateProdctById(Product product, long id) {
		Optional<Product> productDB=productRepository.findById(product.getId());
		if(productDB.isPresent()) {
			Product productUpdate=productDB.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;
		}
		throw new ResourceNotFoundException("Record Not Found for id : "+product.getId());
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		Optional<Product> productDB=productRepository.findById(id);
		if(productDB.isPresent()) {
			return productDB.get();
		}
		throw new ResourceNotFoundException("Record Not Found for id : "+id);
	}

	@Override
	public void deleteProductById(long id) {
		Optional<Product> productDB=productRepository.findById(id);
		if(productDB.isPresent()) {
			productRepository.deleteById(id);
		}
		else
		throw new ResourceNotFoundException("Record Not Found for id : "+id);
	}


}
