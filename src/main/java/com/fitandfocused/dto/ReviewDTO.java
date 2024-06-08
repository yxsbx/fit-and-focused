package com.fitandfocused.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long userId;
    private Long trainerId;
    private String comment;
    private int rating;
}