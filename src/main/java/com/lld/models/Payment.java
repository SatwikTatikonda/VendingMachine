package com.lld.models;

import java.util.List;

public class Payment {
    public int totalAmount;
    public int totalAmountPaidByCustomer;
    public List<String> productList;
    public PaymentStatus paymentStatus;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmountPaidByCustomer() {
        return totalAmountPaidByCustomer;
    }

    public void setTotalAmountPaidByCustomer(int totalAmountPaidByCustomer) {
        this.totalAmountPaidByCustomer = totalAmountPaidByCustomer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
