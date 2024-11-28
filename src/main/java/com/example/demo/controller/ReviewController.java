package com.example.demo.controller;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/list")
    public List<Review> ReviewList() {
        return reviewService.findAll();
    }

    @GetMapping("/list/{reviewId}")
    public Review ReviewList(@PathVariable Integer reviewId) {
        return reviewService.findById(reviewId);
    }

    @PatchMapping("/list/update")
    public Review updateReview(@RequestBody Review review) {

        return reviewService.save(review);
    }

    @PostMapping("/list/create")
    public Review createReviewt(@RequestBody Review review) {
        review.setId(0);
        return reviewService.save(review);
    }

    @DeleteMapping("/list/{reviewId}")
    public String deleteReviewt(@PathVariable Integer reviewId) {
        reviewService.delete(reviewId);

        return "The Review deleted " + reviewId;
    }
}
