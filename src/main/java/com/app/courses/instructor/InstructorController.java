package com.app.courses.instructor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public List<Instructor> Instructors() {
        return instructorService.findAll();
    }

    @GetMapping("{instructorId}")
    public Instructor Instructor(@PathVariable Integer instructorId) {
        System.out.println(instructorService.findById(instructorId));
        return instructorService.findById(instructorId);
    }

    @DeleteMapping("{instructorId}")
    public String deleteInstructor(@PathVariable Integer InstructorId) {
        Instructor instructor = instructorService.findById(InstructorId);
        instructorService.delete(instructor);
        return "the Instructor deleted" + " " + instructor.getLastName();
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    @PatchMapping("{instructorId}")
    public Instructor updateInstructor(Integer instructorId, @RequestBody Instructor instructor) {
        Instructor instructor1 = instructorService.findById(instructorId);
        instructor1.setEmail(instructor.getEmail());
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        return instructorService.save(instructor1);
    }
}
