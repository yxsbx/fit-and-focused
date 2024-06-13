package com.fitandfocused.controller;

import com.fitandfocused.dto.*;
import com.fitandfocused.model.*;
import com.fitandfocused.service.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteService athleteService;

    @PostMapping("/register")
    public ResponseEntity<Athlete> register(@RequestBody UserDTO userDTO) {
        Athlete athlete = athleteService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(athlete);
    }

    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewDTO) {
        Review review;
        review = athleteService.addReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @GetMapping("/checkAvailability/{userId}/{day}/{startTime}/{endTime}")
    public ResponseEntity<Boolean> getWorkingDays(
            @PathVariable Long userId,
            @PathVariable String day,
            @PathVariable String startTime,
            @PathVariable String endTime) {
        boolean isAvailable = athleteService.getWorkingDays(userId, day, startTime, endTime);
        return ResponseEntity.ok(isAvailable);
    }
}