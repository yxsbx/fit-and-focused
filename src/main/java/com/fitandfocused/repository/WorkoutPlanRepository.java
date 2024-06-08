package com.fitandfocused.repository;

import com.fitandfocused.model.WorkoutPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutPlanRepository extends BaseRepository<WorkoutPlan, Long> {
}