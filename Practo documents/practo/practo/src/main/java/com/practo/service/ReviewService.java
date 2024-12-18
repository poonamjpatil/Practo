package com.practo.service;


import com.practo.entity.Review;
import com.practo.payload.ReviewDto;

public interface ReviewService {


    Review createReview(ReviewDto reviewDto);
}
