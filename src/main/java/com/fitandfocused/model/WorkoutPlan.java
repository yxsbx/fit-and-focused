package com.fitandfocused.model;

import lombok.Data;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_workout_plan")
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private BigDecimal pricePerHour;
}
