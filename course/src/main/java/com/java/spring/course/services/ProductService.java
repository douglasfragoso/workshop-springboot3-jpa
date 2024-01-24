package com.java.spring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.java.spring.course.model.Product;
import com.java.spring.course.repository.ProductRepository;


@Service 
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(@NonNull Long id) { 
        Optional<Product> obj = repository.findById(id); 
        return obj.get();
    }

}
