package com.ravi.major.service;

import com.ravi.major.model.Payment;
import com.ravi.major.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    public void makePayment(Payment payment){
        paymentRepository.save(payment);

    }
}
