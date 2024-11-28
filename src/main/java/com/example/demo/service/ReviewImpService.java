package com.example.demo.service;

import com.example.demo.dao.ReviewDAO;
import com.example.demo.entity.Review;
import com.example.demo.exception.ErrorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewImpService implements ReviewService {
    private ReviewDAO reviewDAO;

    @Autowired
    public ReviewImpService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;

    }

    @Override
    public List<Review> findAll() {
        return reviewDAO.findAll();
    }

    @Override
    public Review findById(Integer id) {
        Optional<Review> optional = reviewDAO.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }

    @Override
    @Transactional
    public Review save(Review Review) {
        return reviewDAO.save(Review);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Optional<Review> optional = reviewDAO.findById(id);
        if (optional.isPresent()) {
            reviewDAO.delete(optional.get());
        } else throw new ErrorNotFoundException("We cannot found the id " + id);
    }
}
