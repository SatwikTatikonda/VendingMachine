package com.lld.exceptions;

public class AmountInsufficient extends RuntimeException
{
    public AmountInsufficient(String message) {
        super(message);
    }
}
