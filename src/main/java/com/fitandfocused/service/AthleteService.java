package com.fitandfocused.service;

import com.fitandfocused.dto.*;
import com.fitandfocused.model.*;
import com.fitandfocused.repository.*;

import com.fitandfocused.repository.AthleteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteService {

    private final AthleteRepository athleteRepository;
    private final ReviewRepository reviewRepository;

    public Athlete registerUser(UserDTO userDTO) {
        Athlete athlete = new Athlete();
        athlete.setName(userDTO.getName());
        athlete.setEmail(userDTO.getEmail());
        athlete.setPassword(userDTO.getPassword());
        athlete.setPhoneNumber(userDTO.getPhoneNumber());
        athlete.setAddress(userDTO.getAddress());
        return athleteRepository.save(athlete);
    }

    public boolean verifyCref(String cref) {
        return true;
    }

    public Review addReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setUserId(reviewDTO.getUserId());
        review.setTrainerId(reviewDTO.getTrainerId());
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        return reviewRepository.save(review);
    }

    public List<Review> getReviews(Long userId) {
        return reviewRepository.findAll();
    }


    public boolean checkAvailability(Long userId, String day, String startTime, String endTime) {
        return true;
    }

}
