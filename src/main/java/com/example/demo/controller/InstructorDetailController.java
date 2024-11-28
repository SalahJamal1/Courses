package com.example.demo.controller;

import com.example.demo.entity.Instructor_detail;
import com.example.demo.service.InstructorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructorDetail")
public class InstructorDetailController {
    private InstructorDetailService instructorDetailService;

    @Autowired
    public InstructorDetailController(InstructorDetailService instructorDetailService) {
        this.instructorDetailService = instructorDetailService;
    }

    @GetMapping("/list")
    public List<Instructor_detail> instructorDetailList() {
        return instructorDetailService.findAll();
    }

    @GetMapping("/list/{instructorDetailId}")
    public Instructor_detail instructorDetail(@PathVariable Integer instructorDetailId) {
        return instructorDetailService.findById(instructorDetailId);
    }

    @PatchMapping("/list/update")
    public Instructor_detail updateinstructorDetail(@RequestBody Instructor_detail instructor_detail) {
        return instructorDetailService.save(instructor_detail);
    }

    @PostMapping("/list/create")
    public Instructor_detail createinstructorDetail(@RequestBody Instructor_detail instructor_detail) {
        instructor_detail.setId(0);
        instructor_detail.getInstructor().setId(0);
        return instructorDetailService.save(instructor_detail);
    }

    @DeleteMapping("/list/{instructorId}")
    public String deleteInstructort(@PathVariable Integer instructorId) {
        Instructor_detail instructor_detail = instructorDetailService.findById(instructorId);
        instructorDetailService.delete(instructorId);

        return "The Instructor deleted " + instructor_detail.getInstructor().getFirst_name();
    }
}
