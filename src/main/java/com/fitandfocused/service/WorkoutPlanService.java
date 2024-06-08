package com.fitandfocused.service;

import com.fitandfocused.dto.WorkoutPlanDTO;
import com.fitandfocused.model.WorkoutPlan;
import com.fitandfocused.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WorkoutPlanService {

    private final WorkoutPlanRepository workoutPlanRepository;

    public WorkoutPlan createWorkoutPlan(WorkoutPlanDTO workoutPlanDTO) {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setUserId(workoutPlanDTO.getUserId());
        workoutPlan.setDayOfWeek(workoutPlanDTO.getDayOfWeek());
        workoutPlan.setStartTime(workoutPlanDTO.getStartTime());
        workoutPlan.setEndTime(workoutPlanDTO.getEndTime());
        workoutPlan.setPricePerHour(workoutPlanDTO.getPricePerHour());
        return workoutPlanRepository.save(workoutPlan);
    }

    public boolean checkAvailability(Long userId, String day, String startTime, String endTime) {
        return true;
    }
}
