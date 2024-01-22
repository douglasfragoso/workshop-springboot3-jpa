package com.java.spring.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.course.model.User;

public interface UserRepository extends JpaRepository<User, Long>{ // JpaRepository<Entidade, Tipo da chave primária da entidade>
    
}
