package com.app.courses.student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(Integer id);

    void delete(Student student);

    Student save(Student student);
}
