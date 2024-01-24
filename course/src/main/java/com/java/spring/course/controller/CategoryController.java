package com.java.spring.course.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.course.model.Category;
import com.java.spring.course.services.CategoryService;
import java.util.List;

@RestController 
@RequestMapping(value = "/categories") 
public class CategoryController {
    
    @Autowired 
    private CategoryService service;

    @GetMapping 
    public ResponseEntity<List<Category>> findAll() { 
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list); 
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable @NonNull Long id) { 
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

    }
}
