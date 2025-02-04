package com.app.courses.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseImpService implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("we cannot found the id"));
    }

    @Override
    @Transactional
    public void delete(Course course) {
        courseRepository.delete(course);
    }

    @Override
    @Transactional
    public Course save(Course course) {

        return courseRepository.save(course);
    }

}
