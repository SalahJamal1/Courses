package com.example.demo.service;

import com.example.demo.entity.Instructor_detail;

import java.util.List;

public interface InstructorDetailService {
    List<Instructor_detail> findAll();

    Instructor_detail findById(Integer id);

    Instructor_detail save(Instructor_detail instructor_detail);

    void delete(Integer id);
}
