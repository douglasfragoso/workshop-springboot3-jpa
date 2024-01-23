package com.java.spring.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.course.model.User;

@Repository// This annotation is used to indicate that a class is a "Repository" - opcional pois já está herdando do JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{ // JpaRepository<Entidade, Tipo da chave primária da entidade>
    
}
