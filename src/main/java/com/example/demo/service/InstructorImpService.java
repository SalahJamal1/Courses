package com.example.demo.service;

import com.example.demo.dao.InstructorDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.ErrorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorImpService implements InstructorService {
    private InstructorDAO instructorDAO;

    @Autowired
    public InstructorImpService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;

    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(Integer id) {
        Optional<Instructor> optional = instructorDAO.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorDAO.save(instructor);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Optional<Instructor> optional = instructorDAO.findById(id);
        if (optional.isPresent()) {
            instructorDAO.delete(optional.get());
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }
}
