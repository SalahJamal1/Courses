package com.example.demo.service;

import com.example.demo.dao.CourseDAO;
import com.example.demo.entity.Course;
import com.example.demo.exception.ErrorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImpService implements CourseService {
    private CourseDAO CourseDAO;

    @Autowired
    public CourseImpService(CourseDAO CourseDAO) {
        this.CourseDAO = CourseDAO;

    }

    @Override
    public List<Course> findAll() {
        return CourseDAO.findAll();
    }

    @Override
    public Course findById(Integer id) {
        Optional<Course> optional = CourseDAO.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }

    @Override
    @Transactional
    public Course save(Course Course) {
        return CourseDAO.save(Course);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Optional<Course> optional = CourseDAO.findById(id);
        if (optional.isPresent()) {
            CourseDAO.delete(optional.get());
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }
}
