package com.fitandfocused.repository;

import com.fitandfocused.model.PersonalTrainer;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainerRepository extends BaseRepository<PersonalTrainer, Long> {

    boolean existsByEmail(String email);
    boolean existsByCref(String cref);
}