package com.kiran.payment_server.dto;

import com.kiran.payment_server.PaymentMethod;

import java.math.BigDecimal;

public record PaymentResponse(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId

) {
}
