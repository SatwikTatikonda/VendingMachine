package com.lld.controller;

import com.lld.dto.OrderSummary;
import com.lld.exceptions.VendingMachineNotFound;
import com.lld.models.Cart;
import com.lld.models.Product;
import com.lld.models.ProductCategory;
import com.lld.service.VendingMachineService;

import java.util.List;
import java.util.Map;

public class VendingMachineController {

    private final VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public List<Product> getListOfProducts(int machineId){
        try {
            return vendingMachineService.getProductsList(machineId);
        }
        catch (VendingMachineNotFound vendingMachineNotFound){
            System.out.println(vendingMachineNotFound);
            return null;
        }
    }

    public List<Product> getCategoryWiseProducts(int machineId, ProductCategory productCategory){
        return vendingMachineService.getProductsByCategory(machineId,productCategory);
    }

    public Cart addToCart(Product product, Long machineId){
       return vendingMachineService.addToCart(machineId,product);
    }

    public OrderSummary checkout(Map<Integer,Product> productsList, Long machineId){
        return vendingMachineService.checkOut(productsList,machineId);
    }

}
