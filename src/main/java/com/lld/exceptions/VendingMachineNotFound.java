package com.lld.exceptions;

public class VendingMachineNotFound extends RuntimeException {
    public VendingMachineNotFound(String message){
        super(message);
    }
}
