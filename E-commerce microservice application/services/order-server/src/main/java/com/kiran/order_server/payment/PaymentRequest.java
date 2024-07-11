package com.kiran.order_server.payment;


import com.kiran.order_server.customer.CustomerResponse;
import com.kiran.order_server.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
