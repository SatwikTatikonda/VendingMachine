package com.lld.dto;
import java.util.Map;


public class OrderSummary
{
    private int totalAmountToBePaid;
    private Map<String,Map<Integer,Integer>> OrderDetails;

    public int getTotalAmountToBePaid() {
        return totalAmountToBePaid;
    }

    public void setTotalAmountToBePaid(int totalAmountToBePaid) {
        this.totalAmountToBePaid = totalAmountToBePaid;
    }

    public Map<String, Map<Integer, Integer>> getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(Map<String, Map<Integer, Integer>> orderDetails) {
        OrderDetails = orderDetails;
    }
}
