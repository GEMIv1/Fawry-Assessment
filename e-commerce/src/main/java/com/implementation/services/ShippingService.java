package com.implementation.services;

import java.util.List;

import com.implementation.model.abstractions.Shippable;

public class ShippingService {
    private static final double RATE_PER_KG  = 7;// assuimg the cost per kilo is 7 pounds

    public double calculateFee(List<Shippable> items) {
        double totalWeight = 0;
        for (Shippable item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight * RATE_PER_KG;
    }

    public void shipItems(List<Shippable> items) {
        System.out.println("Shipping " + items.size() + " item(s)");
        for (Shippable item : items) {
                System.out.printf("  %s: %.2f kg%n",item.getName(),item.getWeight());
        }
        System.out.printf("Total shipping fee: $%.2f%n", calculateFee(items));
    }
}
