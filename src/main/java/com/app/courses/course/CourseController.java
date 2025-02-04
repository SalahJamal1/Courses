package com.app.courses.course;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> courses() {
        return courseService.findAll();
    }

    @GetMapping("{courseId}")
    public Course course(@PathVariable Integer courseId) {
        return courseService.findById(courseId);
    }

    @DeleteMapping("{courseId}")
    public String deleteCourse(@PathVariable Integer courseId) {
        Course course = courseService.findById(courseId);
        courseService.delete(course);
        return "the course deleted" + " " + course.getTitle();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {

        return courseService.save(course);
    }

    @PatchMapping("{courseId}")
    public Course updateCourse(Integer courseId, @RequestBody Course course) {
        Course course1 = courseService.findById(courseId);
        course1.setTitle(course.getTitle());
        return courseService.save(course1);
    }
}
