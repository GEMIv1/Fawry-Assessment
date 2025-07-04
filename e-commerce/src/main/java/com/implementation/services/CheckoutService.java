package com.implementation.services;


import java.util.List;

import com.implementation.model.abstractions.Shippable;
import com.implementation.model.concrete.UserRelated.Cart;
import com.implementation.model.concrete.UserRelated.Customer;


public class CheckoutService {

    private final ShippingService shippingService;
    private final ReceiptPrinter printer;
    
    public CheckoutService(ShippingService shippingService, ReceiptPrinter printer) {
        this.shippingService = shippingService;
        this.printer = printer;
    }

    public void checkout(Cart cart, Customer customer) {
        if (cart.isEmpty())throw new IllegalStateException("Cannot checkout: cart is empty");

        double subtotal = cart.subtotal();
        List<Shippable> toShip = cart.shippables();
        double shippingFee = shippingService.calculateFee(toShip);
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total)throw new IllegalStateException("Insufficient balance: have " + customer.getBalance() + ", need " +total);
        customer.debit(total);

        if (!toShip.isEmpty()) {
            shippingService.shipItems(toShip);
        }
        printer.printReceipt(cart.getEntries() , subtotal, shippingFee, total, customer.getBalance());
    }

  
}

