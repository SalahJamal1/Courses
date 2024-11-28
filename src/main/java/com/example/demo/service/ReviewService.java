package com.example.demo.service;

import com.example.demo.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();

    Review findById(Integer id);

    Review save(Review Review);

    void delete(Integer id);
}
