package com.app.courses.course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course findById(Integer id);

    void delete(Course course);

    Course save(Course course);

}
