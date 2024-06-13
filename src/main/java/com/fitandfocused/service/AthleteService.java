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

    // Todos os campos obrigatorios, password criptografada, email unico, contato único
    public Athlete registerUser(UserDTO userDTO) {
        Athlete athlete = new Athlete();
        athlete.setName(userDTO.getName());
        athlete.setEmail(userDTO.getEmail());
        athlete.setPassword(userDTO.getPassword());
        athlete.setPhoneNumber(userDTO.getPhoneNumber());
        athlete.setAddress(userDTO.getAddress());
        return athleteRepository.save(athlete);
    }

    // Futuramente, implementar report de profissionais
    // Quantidade de estrelas obrigatório para somente o primeiro treino do atleta com determinado profissional
    // Texto do review opcional
    // Aparecer somente ao final do treino
    public Review addReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setUserId(reviewDTO.getUserId());
        review.setTrainerId(reviewDTO.getTrainerId());
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating()); // 1 a 5 estrelas
        return reviewRepository.save(review);
    }

    // Verifica se o atleta tem disponibilidade no horário informado
    public boolean getWorkingDays(Long userId, String day, String startTime, String endTime) {
        return true;
    }
}
