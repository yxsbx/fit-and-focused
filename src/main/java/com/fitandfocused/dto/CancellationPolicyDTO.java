package com.fitandfocused.dto;

import lombok.Data;

@Data
public class CancellationPolicyDTO {
    private Long trainerId;
    private Integer minimumNoticeHours;
    private String penalty;
}