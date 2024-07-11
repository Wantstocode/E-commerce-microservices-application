package com.kiran.payment_server.service;

import com.kiran.payment_server.dto.PaymentNotificationRequest;
import com.kiran.payment_server.dto.PaymentRequest;
import com.kiran.payment_server.dto.PaymentResponse;
import com.kiran.payment_server.mapper.PaymentMapper;
import com.kiran.payment_server.notification.NotificationProducer;
import com.kiran.payment_server.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = this.paymentRepository.save(this.mapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }

    public PaymentResponse findById(int id){
        return paymentRepository.findById(id)
                .map(this.mapper::fromPayment)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }

    public List<PaymentResponse> findAll(){
        return paymentRepository.findAll()
                .stream()
                .map(this.mapper::fromPayment)
                .collect(Collectors.toList());
    }
}