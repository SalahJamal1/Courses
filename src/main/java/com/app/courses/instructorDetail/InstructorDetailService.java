package com.app.courses.instructorDetail;

import java.util.List;

public interface InstructorDetailService {
    List<InstructorDetail> findAll();

    InstructorDetail findById(Integer id);

    void delete(InstructorDetail course);

    InstructorDetail save(InstructorDetail course);

}
