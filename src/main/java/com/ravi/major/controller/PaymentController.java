package com.ravi.major.controller;

import com.ravi.major.dto.requestentity.PaymentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @PostMapping("/pay")
    public void makePayment(@RequestBody PaymentRequest paymentRequest){

    }

}
