package com.app.courses.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();

    Review findById(Integer id);

    void delete(Review review);

    Review save(Review review);
}
