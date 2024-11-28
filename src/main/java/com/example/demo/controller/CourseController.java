package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public List<Course> CourseList() {
        return courseService.findAll();
    }

    @GetMapping("/list/{courseId}")
    public Course CourseList(@PathVariable Integer courseId) {
        return courseService.findById(courseId);
    }

    @PatchMapping("/list/update")
    public Course updateCourse(@RequestBody Course course) {
        Course course1 = courseService.findById(course.getId());
        course1.setTitle(course.getTitle());

        return courseService.save(course1);
    }

    @PostMapping("/list/create")
    public Course createCourset(@RequestBody Course course) {
        course.setId(0);
        return courseService.save(course);
    }

    @DeleteMapping("/list/{courseId}")
    public String deleteCourset(@PathVariable Integer courseId) {
        Course course = courseService.findById(courseId);
        courseService.delete(courseId);

        return "The Course deleted " + course.getInstructor().getFirst_name();
    }
}
