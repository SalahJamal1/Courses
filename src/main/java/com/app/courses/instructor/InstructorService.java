package com.app.courses.instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAll();

    Instructor findById(Integer id);

    void delete(Instructor instructor);

    Instructor save(Instructor instructor);

}
