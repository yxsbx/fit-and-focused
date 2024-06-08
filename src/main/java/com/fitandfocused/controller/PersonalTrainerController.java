package com.fitandfocused.controller;

import com.fitandfocused.dto.*;
import com.fitandfocused.model.*;
import com.fitandfocused.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainers")
@RequiredArgsConstructor
public class PersonalTrainerController {

    private final PersonalTrainerService personalTrainerService;
    private final WorkoutPlanService workoutPlanService;
    private final AuthService authService;
    private final PaymentService paymentService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Working", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.loginWithGoogle(loginRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<PersonalTrainer> register(@RequestBody PersonalTrainerDTO personalTrainerDTO) {
        PersonalTrainer personalTrainer = personalTrainerService.registerPersonalTrainer(personalTrainerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personalTrainer);
    }

    @PostMapping("/schedule")
    public ResponseEntity<WorkoutPlan> createWorkoutPlan(@RequestBody WorkoutPlanDTO workoutPlanDTO) {
        WorkoutPlan workoutPlan = workoutPlanService.createWorkoutPlan(workoutPlanDTO);
        return ResponseEntity.ok(workoutPlan);
    }

    @PostMapping("/makePayment")
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequest paymentRequest) {
        String paymentStatus = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(paymentStatus);
    }

    @PostMapping("/setWorkingDays")
    public ResponseEntity<WorkingDays> setWorkingDays(@RequestBody WorkingDaysDTO workingDaysDTO) {
        WorkingDays workingDays = personalTrainerService.setWorkingDays(workingDaysDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(workingDays);
    }

    @PostMapping("/setCancellationPolicy")
    public ResponseEntity<CancellationPolicy> setCancellationPolicy(@RequestBody CancellationPolicyDTO cancellationPolicyDTO) {
        CancellationPolicy policy = personalTrainerService.setCancellationPolicy(cancellationPolicyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(policy);
    }

    @GetMapping("/{trainerId}/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long trainerId) {
        List<Review> reviews = personalTrainerService.getReviews(trainerId);
        return ResponseEntity.ok(reviews);
    }
}
