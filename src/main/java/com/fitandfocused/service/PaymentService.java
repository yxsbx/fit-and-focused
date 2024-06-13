package com.fitandfocused.service;

import com.fitandfocused.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    // API to process payment => qualquer uma que seja de graça
    // Personal paga mensalidade para a plataforma para achar clientes
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
