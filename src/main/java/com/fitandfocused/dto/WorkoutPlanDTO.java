package com.fitandfocused.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WorkoutPlanDTO {
    private Long userId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private BigDecimal pricePerHour;
}