package com.kiran.order_server.kafka;

import com.kiran.order_server.customer.CustomerResponse;
import com.kiran.order_server.order.PaymentMethod;
import com.kiran.order_server.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
