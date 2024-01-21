package com.java.spring.course.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.course.model.User;

@RestController // This annotation is used to create a RESTful controller
@RequestMapping(value = "/users") // This annotation is used to map web requests onto specific handler classes and/or handler methods
public class UserController {
    
    @GetMapping // This annotation is used to map HTTP GET requests onto specific handler methods
    public ResponseEntity<User> findAll() { //ResponsiEntity is a generic type to represent HTTP response
        User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
        return ResponseEntity.ok().body(u); //ok() is a static method that returns a ResponseEntity with the given body and status code
    }
}
