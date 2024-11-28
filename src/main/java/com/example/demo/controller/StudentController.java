package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> StudentList() {
        return studentService.findAll();
    }

    @GetMapping("/list/{studentId}")
    public Student StudentList(@PathVariable Integer studentId) {
        return studentService.findById(studentId);
    }

    @PatchMapping("/list/update")
    public Student updateStudent(@RequestBody Student student) {

        return studentService.save(student);
    }

    @PostMapping("/list/create")
    public Student createStudentt(@RequestBody Student student) {
        student.setId(0);
        return studentService.save(student);
    }

    @DeleteMapping("/list/{StudentId}")
    public String deleteStudentt(@PathVariable Integer studentId) {
        Student student = studentService.findById(studentId);
        studentService.delete(studentId);

        return "The Student deleted " + student.getFirst_name();
    }
}
