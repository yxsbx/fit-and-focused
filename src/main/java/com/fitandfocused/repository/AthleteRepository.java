package com.fitandfocused.repository;

import com.fitandfocused.model.Athlete;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends BaseRepository<Athlete, Long> {
}