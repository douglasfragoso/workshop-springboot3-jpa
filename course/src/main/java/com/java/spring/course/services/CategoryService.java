package com.java.spring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.java.spring.course.model.Category;
import com.java.spring.course.repository.CategoryRepository;


@Service 
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(@NonNull Long id) { 
        Optional<Category> obj = repository.findById(id); 
        return obj.get();
    }

}
