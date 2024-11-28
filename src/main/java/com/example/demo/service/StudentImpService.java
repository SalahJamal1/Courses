package com.example.demo.service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import com.example.demo.exception.ErrorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpService implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentImpService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> optional = studentDAO.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }

    @Override
    @Transactional
    public Student save(Student Student) {
        return studentDAO.save(Student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Optional<Student> optional = studentDAO.findById(id);
        if (optional.isPresent()) {
            studentDAO.delete(optional.get());
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }
}
