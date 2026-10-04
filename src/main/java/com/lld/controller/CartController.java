package com.lld.controller;

import com.lld.models.Product;
import com.lld.service.CartService;

public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public void addToCart(Product productId, long vendingMachineId){
        cartService.addToCard(product,vendingMachineId);
    }
}
