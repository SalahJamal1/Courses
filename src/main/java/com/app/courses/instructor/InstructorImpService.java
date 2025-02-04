package com.app.courses.instructor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorImpService implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findById(Integer id) {
        return instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("we cannot found the id"));
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {

        return instructorRepository.save(instructor);
    }

}
