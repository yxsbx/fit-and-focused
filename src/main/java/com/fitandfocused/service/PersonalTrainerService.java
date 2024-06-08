package com.fitandfocused.service;

import com.fitandfocused.dto.*;
import com.fitandfocused.model.*;
import com.fitandfocused.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalTrainerService {

    private final PersonalTrainerRepository personalTrainerRepository;
    private final ReviewRepository reviewRepository;
    private final WorkingDaysRepository workingDaysRepository;
    private final CancellationPolicyRepository cancellationPolicyRepository;

    public PersonalTrainer registerPersonalTrainer(PersonalTrainerDTO personalTrainerDTO) {
        if (personalTrainerRepository.existsByEmail(personalTrainerDTO.getEmail())) {
            throw new IllegalArgumentException("E-mail já está em uso.");
        }

        if (personalTrainerRepository.existsByCref(personalTrainerDTO.getCref())) {
            throw new IllegalArgumentException("CREF já está em uso.");
        }

        PersonalTrainer personalTrainer = createPersonalTrainerFromDTO(personalTrainerDTO);
        return personalTrainerRepository.save(personalTrainer);
    }

    private PersonalTrainer createPersonalTrainerFromDTO(PersonalTrainerDTO personalTrainerDTO) {
        PersonalTrainer personalTrainer = new PersonalTrainer();
        personalTrainer.setName(personalTrainerDTO.getName());
        personalTrainer.setEmail(personalTrainerDTO.getEmail());
        personalTrainer.setPassword(personalTrainerDTO.getPassword());
        personalTrainer.setCref(personalTrainerDTO.getCref());
        personalTrainer.setPhoneNumber(personalTrainerDTO.getPhoneNumber());
        personalTrainer.setSpecialization(personalTrainerDTO.getSpecialization());
        personalTrainer.setAddress(personalTrainerDTO.getAddress());
        return personalTrainer;
    }

    public WorkingDays setWorkingDays(WorkingDaysDTO workingDaysDTO) {
        Optional<PersonalTrainer> optionalPersonalTrainer = personalTrainerRepository.findById(workingDaysDTO.getTrainerId());
        if (optionalPersonalTrainer.isEmpty()) {
            throw new IllegalArgumentException("PersonalTrainer não encontrado.");
        }

        if (workingDaysDTO.getWorkingDays() == null || workingDaysDTO.getWorkingDays().isEmpty()) {
            throw new IllegalArgumentException("Os dias de trabalho não podem estar vazios.");
        }

        WorkingDays workingDays = createWorkingDaysFromDTO(workingDaysDTO);
        return workingDaysRepository.save(workingDays);
    }

    private WorkingDays createWorkingDaysFromDTO(WorkingDaysDTO workingDaysDTO) {
        WorkingDays workingDays = new WorkingDays();
        workingDays.setTrainerId(workingDaysDTO.getTrainerId());
        workingDays.setWorkingDays(workingDaysDTO.getWorkingDays());
        return workingDays;
    }

    public CancellationPolicy setCancellationPolicy(CancellationPolicyDTO cancellationPolicyDTO) {
        Optional<PersonalTrainer> optionalPersonalTrainer = personalTrainerRepository.findById(cancellationPolicyDTO.getTrainerId());
        if (optionalPersonalTrainer.isEmpty()) {
            throw new IllegalArgumentException("Personal Trainer não encontrado.");
        }

        if (cancellationPolicyDTO.getMinimumNoticeHours() == null) {
            throw new IllegalArgumentException("Os campos de horas de aviso mínimo e penalidade são obrigatórios.");

        } else if (cancellationPolicyDTO.getPenalty() == null) {
            throw new IllegalArgumentException("Os campos de horas de aviso mínimo e penalidade são obrigatórios.");
        }

        CancellationPolicy policy = createCancellationPolicyFromDTO(cancellationPolicyDTO);
        return cancellationPolicyRepository.save(policy);
    }

    private CancellationPolicy createCancellationPolicyFromDTO(CancellationPolicyDTO cancellationPolicyDTO) {
        CancellationPolicy policy = new CancellationPolicy();
        policy.setTrainerId(cancellationPolicyDTO.getTrainerId());
        policy.setMinimumNoticeHours(cancellationPolicyDTO.getMinimumNoticeHours());
        policy.setPenalty(cancellationPolicyDTO.getPenalty());
        return policy;
    }

    public List<Review> getReviews(Long trainerId) {
        return reviewRepository.findAll();
    }
}
