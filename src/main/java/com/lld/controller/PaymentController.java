package com.lld.controller;

import com.lld.dto.OrderSummary;
import com.lld.models.Denomination;
import com.lld.models.Payment;
import com.lld.models.PaymentStatus;
import com.lld.service.PaymentService;

import java.util.Map;

public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public Payment makePayment(OrderSummary orderSummary, Map<Denomination,Integer> amountReceived,Long machineId){
        paymentService.makePayment(orderSummary,amountReceived,machineId);
    }
}
