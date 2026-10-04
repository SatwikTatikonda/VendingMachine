package com.lld.models;

import java.util.List;

public class VendingMachine {
    public Cart cart;
    public VendingMachineStatus vendingMachineStatus;
    public List<Product> products;
    public CashBox cashBox;

    public VendingMachineStatus getVendingMachineStatus() {
        return vendingMachineStatus;
    }

    public void setVendingMachineStatus(VendingMachineStatus vendingMachineStatus) {
        this.vendingMachineStatus = vendingMachineStatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
