package com.java.spring.course.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.java.spring.course.model.User;
import com.java.spring.course.repository.UserRepository;
import com.java.spring.course.services.exceptions.DatabaseException;
import com.java.spring.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service // This annotation is used to indicate that a class is a "Service"
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(@NonNull Long id) { // @NonNull is a Lombok annotation that generates a null check
        Optional<User> obj = repository.findById(id); // Optional is a container object that may or may not contain a
                                                      // non-null value
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // orElseThrow is a method that returns the
                                                                         // value if present, otherwise throws an
                                                                         // exception
    }

    @NonNull
    public User insert(@NonNull User obj) {
        return repository.save(obj);
    }

    public void delete(@NonNull Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(@NonNull Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        Hibernate.initialize(entity.getOrders());
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
