package com.lld.repository;

import com.lld.models.VendingMachine;

import java.util.Map;

public class VendingMachineRepository
{
    Map<Long, VendingMachine> vendingMachineMap;

    public VendingMachine findById(Long vendingMachineId){
        return vendingMachineMap.getOrDefault(vendingMachineId,null);
    }

    public boolean doesProductExists(long vendingMachineId,long productId){
        return vendingMachineMap.get(vendingMachineId)
                .getProducts()
                .stream()
                .anyMatch(product -> product.getId() == productId);
    }






}
