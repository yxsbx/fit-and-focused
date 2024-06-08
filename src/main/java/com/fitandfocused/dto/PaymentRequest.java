package com.fitandfocused.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long userId;
    private double amount;
    private String paymentMethod;
    private String paymentDetails;
}
