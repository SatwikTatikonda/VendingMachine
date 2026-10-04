package com.lld.models;

import java.util.Map;

public class CashBox {
    public VendingMachine vendingMachine;
    public int totalCashLeft;
    public Map<Denomination,Integer> cashLeftByDenomination;

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public int getTotalCashLeft() {
        return totalCashLeft;
    }

    public void setTotalCashLeft(int totalCashLeft) {
        this.totalCashLeft = totalCashLeft;
    }

    public Map<Denomination, Integer> getCashLeftByDenomination() {
        return cashLeftByDenomination;
    }

    public void setCashLeftByDenomination(Map<Denomination, Integer> cashLeftByDenomination) {
        this.cashLeftByDenomination = cashLeftByDenomination;
    }
}
