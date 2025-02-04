package com.app.courses.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewImpService implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Integer id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("We cannot found the id"));
    }

    @Override
    public void delete(Review review) {
        reviewRepository.delete(review);

    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}
