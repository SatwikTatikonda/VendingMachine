package com.lld.service;

import com.lld.models.Product;
import com.lld.repository.CartRepository;


public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCard(Product product, long machineId) {
        cartRepository.findById(mach
    }
}
