package com.app.courses.review;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<Review> Reviews() {
        return reviewService.findAll();
    }

    @GetMapping("/{reviewId}")
    public Review Review(@PathVariable Integer reviewId) {
        return reviewService.findById(reviewId);
    }

    @PatchMapping("/{reviewId}")
    public Review updateReview(@PathVariable Integer reviewId, @RequestBody Review review) {
        Review review1 = reviewService.findById(reviewId);
        review1.setComment(review.getComment());
        return reviewService.save(review1);
    }

    @DeleteMapping("/{reviewId}")
    public String deleteReview(@PathVariable Integer reviewId) {
        Review review1 = reviewService.findById(reviewId);
        reviewService.delete(review1);
        return "we deleted the " + review1.getId();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.save(review);
    }
}
