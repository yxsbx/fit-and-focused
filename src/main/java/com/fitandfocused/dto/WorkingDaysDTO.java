package com.fitandfocused.dto;

import lombok.Data;

import java.util.List;

@Data
public class WorkingDaysDTO {
    private Long trainerId;
    private List<String> workingDays;
}
