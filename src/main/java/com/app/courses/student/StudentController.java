package com.app.courses.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> students() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public Student student(@PathVariable Integer studentId) {
        return studentService.findById(studentId);
    }

    @PatchMapping("/{studentId}")
    public Student updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        Student student1 = studentService.findById(studentId);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        return studentService.save(student1);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId) {
        Student student1 = studentService.findById(studentId);
        studentService.delete(student1);
        return "we deleted the " + student1.getId();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
}
