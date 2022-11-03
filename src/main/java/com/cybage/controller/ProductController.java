package com.cybage.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Product;
import com.cybage.service.ProductService;



@RestController
public class ProductController {
	Logger log = LogManager.getLogger();

	@Autowired
	ProductService service;
	
	@GetMapping
    public ResponseEntity<List<Product>> getAllTodos() {
        List<Product> products = service.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
	
	@GetMapping("/product/{id}")
    public ResponseEntity<Product> getTodo(@PathVariable Long id) {
        return new ResponseEntity<>(service.getproductById(id), HttpStatus.OK);
    }
	
	@PostMapping("/createProduct")
	 public ResponseEntity<Product> saveTodo(@RequestBody Product product) {
        Product product1 = service.insert(product);
     
        return new ResponseEntity<>(product1,HttpStatus.CREATED);
    }
	@PutMapping({"/{productId}"})
    public ResponseEntity<Product> updateTodo(@PathVariable("id") Long id, @RequestBody Product product) {
        service.updateProduct(id, product);
        return new ResponseEntity<>(service.getproductById(id), HttpStatus.OK);
    }
	
	@DeleteMapping({"/{productId}"})
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long id) {
        service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
}
