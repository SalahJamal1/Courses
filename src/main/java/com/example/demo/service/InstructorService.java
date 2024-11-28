package com.example.demo.service;

import com.example.demo.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAll();

    Instructor findById(Integer id);

    Instructor save(Instructor instructor);

    void delete(Integer id);
}
