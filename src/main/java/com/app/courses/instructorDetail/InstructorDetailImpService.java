package com.app.courses.instructorDetail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorDetailImpService implements InstructorDetailService {
    private final InstructorDetailRepository instructorDetailRepository;

    @Override
    public List<InstructorDetail> findAll() {
        return instructorDetailRepository.findAll();
    }

    @Override
    public InstructorDetail findById(Integer id) {
        return instructorDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("we cannot found the id"));
    }

    @Override
    @Transactional
    public void delete(InstructorDetail instructorDetail) {
        instructorDetailRepository.delete(instructorDetail);
    }

    @Override
    @Transactional
    public InstructorDetail save(InstructorDetail instructorDetail) {

        return instructorDetailRepository.save(instructorDetail);
    }

}
