package com.java.spring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.java.spring.course.model.Order;
import com.java.spring.course.repository.OrderRepository;

@Service 
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(@NonNull Long id) { 
        Optional<Order> obj = repository.findById(id); 
        return obj.get();
    }

}
