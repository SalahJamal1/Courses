package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/list")
    public List<Instructor> instructorList() {
        return instructorService.findAll();
    }

    @GetMapping("/list/{instructorId}")
    public Instructor instructorList(@PathVariable Integer instructorId) {
        return instructorService.findById(instructorId);
    }

    @PatchMapping(value = "/list/update")
    public Instructor updateInstructort(@RequestBody Instructor instructor) {
        Instructor instructor1 = instructorService.findById(instructor.getId());
        instructor1.setFirst_name(instructor.getFirst_name());
        instructor1.setLast_name(instructor.getLast_name());
        instructor1.setEmail(instructor.getEmail());
        return instructorService.save(instructor1);
    }

    @PostMapping("/list/create")
    public Instructor createInstructort(@RequestBody Instructor instructor) {
        instructor.setId(0);
        instructor.getInstructorDetail().setId(0);
        for (Course i : instructor.getCourses()) {

            instructor.addCourses(i);
        }

        return instructorService.save(instructor);
    }

    @DeleteMapping("/list/{instructorId}")
    public String deleteInstructort(@PathVariable Integer instructorId) {
        Instructor instructor = instructorService.findById(instructorId);
        instructorService.delete(instructorId);

        return "The Instructor deleted " + instructor.getFirst_name();
    }
}
