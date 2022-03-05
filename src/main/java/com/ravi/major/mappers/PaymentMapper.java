package com.ravi.major.mappers;

import com.ravi.major.dto.requestentity.PaymentRequest;
import com.ravi.major.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment paymentRequestToPayment(PaymentRequest paymentRequest){
        Payment payment = new Payment();
        payment.setCardNumber(paymentRequest.getCardNumber());
        payment.setCardHolderName(paymentRequest.getCardHolderName());
        payment.setCvvNumber(paymentRequest.getCvvNumber());
        payment.setExpiryDate(paymentRequest.getExpiryDate());
        payment.setStatus(paymentRequest.getStatus());
        return payment;
    }
}
