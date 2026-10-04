package com.lld.service;

import com.lld.dto.OrderSummary;
import com.lld.exceptions.AmountInsufficient;
import com.lld.exceptions.NoChangeAvlble;
import com.lld.exceptions.VendingMachineNotFound;
import com.lld.models.CashBox;
import com.lld.models.Denomination;
import com.lld.models.Payment;
import com.lld.models.PaymentStatus;
import com.lld.repository.PaymentRepository;
import com.lld.repository.VendingMachineRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PaymentService {

    PaymentRepository paymentRepository;
    VendingMachineRepository vendingMachineRepository;

    public PaymentService(PaymentRepository paymentRepository, VendingMachineRepository vendingMachineRepository) {
        this.paymentRepository = paymentRepository;
        this.vendingMachineRepository = vendingMachineRepository;
    }

    public Payment makePayment(OrderSummary orderSummary, Map<Denomination, Integer> amountReceived, long machineId) {

        if (vendingMachineRepository.findById(machineId) == null) {
            throw new VendingMachineNotFound("VendingMachine Not found");
        }
        Payment payment = new Payment();
        var totalAmountReceived = 0;
        CashBox cashBox=vendingMachineRepository.findById(machineId).getCashBox();

        for (Map.Entry<Denomination, Integer> entry : amountReceived.entrySet()) {
            totalAmountReceived += (entry.getKey().toInteger(entry.getKey()) * entry.getValue());
        }
        if(totalAmountReceived<orderSummary.getTotalAmountToBePaid()){
            throw new AmountInsufficient("amount insufficient");
        }
        else if(totalAmountReceived>orderSummary.getTotalAmountToBePaid()){
            List<Integer> returnedAmount=canReturnChange(totalAmountReceived-orderSummary.getTotalAmountToBePaid(),cashBox).isEmpty();
            if(returnedAmount.isEmpty()) {
                throw new NoChangeAvlble("no sufficient change available");
            }
            return returnedAmount;
        }
        else{

        }
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        payment.setProductList(orderSummary.getOrderDetails().keySet().stream().toList());

    }

    public List<Integer> canReturnChange(int changeNeeded,CashBox cashBox){
        List<Integer>returnedAmount= new ArrayList<>();
        var sortedDenominations = Denomination.denominationToInteger.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        for(int denominationValue : sortedDenominations){
            if(denominationValue>changeNeeded){
                continue;
            }
            else{
               int countOfDenominationValue=cashBox.getCashLeftByDenomination().get(denominationValue);
                while(countOfDenominationValue>0){
                    changeNeeded-=(denominationValue);
                    returnedAmount.add(denominationValue);
                    countOfDenominationValue-=1;
                }
            }
        }
        return changeNeeded==0 ? returnedAmount: List.of();
    }
}
