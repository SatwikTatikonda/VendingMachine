package com.lld.models;

import java.util.Map;

public enum Denomination {
    FIVE,
    TEN,
    HUNDRED,
    FIVE_HUNDRED;

    public final static Map<Denomination,Integer> denominationToInteger = Map.of(FIVE,5,TEN,10,HUNDRED,100,FIVE_HUNDRED,500);

    public int toInteger(Denomination denomination){
        return denominationToInteger.get(denomination);
    }
}
