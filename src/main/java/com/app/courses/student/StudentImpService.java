package com.app.courses.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpService implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("We cannot found the id"));
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);

    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
