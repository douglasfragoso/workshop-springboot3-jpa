package com.java.spring.course.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.spring.course.model.User;
import com.java.spring.course.services.UserService;

import java.net.URI;
import java.util.List;

@RestController // This annotation is used to create a RESTful controller
@RequestMapping(value = "/users") // This annotation is used to map web requests onto specific handler classes and/or handler methods
public class UserController {
    
    @Autowired // This annotation is used to auto wire bean on the setter method, constructor or a field
    private UserService service;// This annotation is used to inject dependencies automatically

    @GetMapping // This annotation is used to map HTTP GET requests onto specific handler methods
    public ResponseEntity<List<User>> findAll() { //ResponsiEntity is a generic type to represent HTTP response
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); //ok() is a static method that returns a ResponseEntity with the given body and status code
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable @NonNull Long id) { // @PathVariable is used to bind a URI template variable to a method parameter
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
    }

    @PostMapping
	public ResponseEntity<User> insert(@RequestBody @NonNull User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") 
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

    @PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable @NonNull Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
