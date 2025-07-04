package com.implementation.services;

import java.util.Map;

import com.implementation.model.abstractions.Product;

public class ReceiptPrinter {
    public void printReceipt(Map<Product,Integer> items , double subtotal, double shippingFee, double totalPaid,  double remainingBalance) {

        System.out.println("===== CHECKOUT RECEIPT =====");
        System.out.println("Items:");

         for (var e : items.entrySet()) {
             Product product  = e.getKey();
            int qty = e.getValue();
            double  unitPrice= product.getPrice();
            double lineTotal= unitPrice * qty;

            System.out.printf("  %2dx %-20s @ $%6.2f = $%6.2f%n",qty,product.getName(),unitPrice, lineTotal);

        }

        System.out.println("-----------------------------");

        System.out.println("Subtotal:          $" + String.format("%.2f", subtotal));
        System.out.println("Shipping fees:     $" + String.format("%.2f", shippingFee));
        System.out.println("Total paid:        $" + String.format("%.2f", totalPaid));
        System.out.println("Remaining balance: $" + String.format("%.2f", remainingBalance));
        System.out.println("============================");
    }
}
