package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Product;
import com.cybage.repository.ProductRepository;

@Service
public class ProductService {
	
	List<Product> products;
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        repo.findAll().forEach(products::add);
        return products;
    }
	public Product insert(Product product) {
        return repo.save(product);
        
    }
	public void deleteTodo(Long Id) {
	      repo.deleteById(Id);
	      
    }
	public Product getproductById(Long id) {
        return repo.findById(id).get();
    }

	
}
