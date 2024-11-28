package com.example.demo.service;

import com.example.demo.dao.InstructorDetailDAO;
import com.example.demo.entity.Instructor_detail;
import com.example.demo.exception.ErrorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDetailImpService implements InstructorDetailService {
    private InstructorDetailDAO instructorDetailDAO;

    @Autowired
    public InstructorDetailImpService(InstructorDetailDAO instructorDetailDAO) {
        this.instructorDetailDAO = instructorDetailDAO;

    }

    @Override
    public List<Instructor_detail> findAll() {
        return instructorDetailDAO.findAll();
    }

    @Override
    public Instructor_detail findById(Integer id) {
        Optional<Instructor_detail> optional = instructorDetailDAO.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }

    @Override
    @Transactional
    public Instructor_detail save(Instructor_detail instructor_detail) {
        return instructorDetailDAO.save(instructor_detail);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Optional<Instructor_detail> optional = instructorDetailDAO.findById(id);
        if (optional.isPresent()) {
            instructorDetailDAO.delete(optional.get());
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }
}
