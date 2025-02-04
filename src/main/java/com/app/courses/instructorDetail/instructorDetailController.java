package com.app.courses.instructorDetail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructorDetails")
@RequiredArgsConstructor
public class instructorDetailController {
    private final InstructorDetailService instructorDetailService;

    @GetMapping
    public List<InstructorDetail> Instructors() {
        return instructorDetailService.findAll();
    }

    @GetMapping("{instructorDetailId}")
    public InstructorDetail Instructor(@PathVariable Integer instructorDetailId) {
        return instructorDetailService.findById(instructorDetailId);
    }

    @DeleteMapping("{instructorDetailId}")
    public String deleteInstructor(@PathVariable Integer instructorDetailId) {
        InstructorDetail instructorDetail = instructorDetailService.findById(instructorDetailId);
        instructorDetailService.delete(instructorDetail);
        return "the Instructor deleted" + " " + instructorDetail.getYoutube_channel();
    }

    @PostMapping
    public InstructorDetail createInstructor(@RequestBody InstructorDetail instructorDetail) {

        return instructorDetailService.save(instructorDetail);
    }

    @PatchMapping("{instructorDetailId}")
    public InstructorDetail updateInstructor(Integer instructorDetailId, @RequestBody InstructorDetail instructorDetail) {
        InstructorDetail instructorDetail1 = instructorDetailService.findById(instructorDetailId);
        instructorDetail1.setHobby(instructorDetail.getHobby());
        instructorDetail1.setYoutube_channel(instructorDetail.getYoutube_channel());
        return instructorDetailService.save(instructorDetail1);
    }
}
