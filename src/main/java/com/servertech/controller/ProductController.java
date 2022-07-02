package com.servertech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servertech.model.Product;
import com.servertech.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create/")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(productService.createProduct(product));
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Product>> selectAllProduct(){
		return ResponseEntity.ok().body(productService.getAllProduct());
	}
	
	@PostMapping("/update/")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(productService.updateProduct(product));
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Product> updateProductById(@RequestBody Product product,@PathVariable("id") long id){
		return ResponseEntity.ok().body(productService.updateProdctById(product, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteProductById(@PathVariable long id){
		productService.deleteProductById(id);
		return HttpStatus.OK;
	}
}
