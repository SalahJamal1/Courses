package com.example.demo.dao;


import com.example.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDAO extends JpaRepository<Instructor, Integer> {

}
