package com.java.spring.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.course.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{ 
    
}
