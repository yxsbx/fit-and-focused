package com.fitandfocused.service;

import com.fitandfocused.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    public String processPayment(String paymentRequest) {
        return "";
    }

    public String processPayment(PaymentRequest paymentRequest) {
        return "Payment Successful";
    }

    public String processPayment(Long paymentRequest) {
        return "";
    }
}
