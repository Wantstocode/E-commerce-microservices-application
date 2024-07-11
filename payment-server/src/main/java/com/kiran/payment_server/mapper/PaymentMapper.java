package com.kiran.payment_server.mapper;

import com.kiran.payment_server.dto.PaymentRequest;
import com.kiran.payment_server.dto.PaymentResponse;
import com.kiran.payment_server.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

  public Payment toPayment(PaymentRequest request) {
    if (request == null) {
      return null;
    }
    return Payment.builder()
        .id(request.id())
        .paymentMethod(request.paymentMethod())
        .amount(request.amount())
        .orderId(request.orderId())
        .build();
  }

  public PaymentResponse fromPayment(Payment payment) {
    return new PaymentResponse(
            payment.getId(),
            payment.getAmount(),
            payment.getPaymentMethod(),
            payment.getOrderId()
    );
  }
}
