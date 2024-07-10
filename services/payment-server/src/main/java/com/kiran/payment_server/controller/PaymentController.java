package com.kiran.payment_server.controller;

import com.kiran.payment_server.dto.PaymentRequest;
import com.kiran.payment_server.dto.PaymentResponse;
import com.kiran.payment_server.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentService paymentService;

  @PostMapping
  public ResponseEntity<Integer> createPayment(@RequestBody @Valid PaymentRequest request) {
    return ResponseEntity.ok(this.paymentService.createPayment(request));
  }

  @GetMapping
  public ResponseEntity<List<PaymentResponse>> findAll(){
    return ResponseEntity.ok(this.paymentService.findAll());
  }

  @GetMapping("/{payment-id}")
  public ResponseEntity<PaymentResponse> findById(@PathVariable("payment-id") Integer paymentId) {
    return ResponseEntity.ok(this.paymentService.findById(paymentId));
  }
}

