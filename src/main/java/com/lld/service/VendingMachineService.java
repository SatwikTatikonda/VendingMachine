package com.lld.service;

import com.lld.dto.OrderSummary;
import com.lld.models.Cart;
import com.lld.repository.VendingMachineRepository;
import com.lld.exceptions.ProductNotFound;
import com.lld.exceptions.VendingMachineNotFound;
import com.lld.models.Product;
import com.lld.models.ProductCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VendingMachineService {

    private VendingMachineRepository vendingMachineRepository;

    public VendingMachineService(VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    public List<Product> getProductsList(long vendingMachineId) {
        return Optional.ofNullable(
                        vendingMachineRepository.findById(vendingMachineId)
                ).map(vendingMachine -> vendingMachine.getProducts())
                .orElseThrow(() -> new VendingMachineNotFound("VendingMachine not found"));
    }

    public List<Product> getProductsByCategory(
            long vendingMachineId,
            ProductCategory productCategory) {

        List<Product> products = Optional.ofNullable(
                        vendingMachineRepository.findById(vendingMachineId)
                )
                .map(vendingMachine -> vendingMachine.getProducts())
                .orElseThrow(() ->
                        new VendingMachineNotFound("VendingMachine not found"))
                .stream()
                .filter(product -> product.getProductCategory() == productCategory)
                .toList();

        if (products.isEmpty()) {
            throw new ProductNotFound("No product found for category: " + productCategory);
        }

        return products;
    }

    public Cart addToCart(long vendingMachineId, Product product){
        vendingMachineRepository.findById(vendingMachineId).getCart().getProducts().add(product);
        return vendingMachineRepository.findById(vendingMachineId).getCart();
    }

    public OrderSummary checkOut(Map<Integer,Product> productsDetails, long vendingMachineId){
        OrderSummary orderSummary = new OrderSummary();
        if(vendingMachineRepository.findById(vendingMachineId)!=null){

            var totalAmount=0;
            Map<String,Map<Integer,Integer>> orderInfo=new HashMap<>();
            for(Map.Entry<Integer,Product> entry: productsDetails.entrySet()){
                totalAmount+=(entry.getKey()*entry.getValue().getPrice());
                orderInfo.put(entry.getValue().getProductName(),Map.of(entry.getValue().getQuantityLeft(),entry.getValue().getPrice()));
            }
            orderSummary.setTotalAmountToBePaid(totalAmount);
            orderSummary.setOrderDetails(orderInfo);
        }
        else{
            throw new VendingMachineNotFound("Vending machine Not Found");
        }
        return orderSummary;
    }

}
