package com.kiran.payment_server.repository;

import com.kiran.payment_server.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
