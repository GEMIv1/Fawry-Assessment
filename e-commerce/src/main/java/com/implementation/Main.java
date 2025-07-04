package com.implementation;

import java.time.LocalDate;

import com.implementation.model.abstractions.Product;
import com.implementation.model.concrete.Products.ExpirableAndShipabbleProduct;
import com.implementation.model.concrete.Products.ShippableProduct;
import com.implementation.model.concrete.UserRelated.Cart;
import com.implementation.model.concrete.UserRelated.Customer;
import com.implementation.services.CartService;
import com.implementation.services.CheckoutService;
import com.implementation.services.ReceiptPrinter;
import com.implementation.services.ShippingService;

public class Main {
    public static void main(String[] args) {

        Cart ahmedCart = new Cart();
        CartService cartService = new CartService(ahmedCart);

        Product tv = new ShippableProduct("LG TV", 10000, 5, 35);
        Product romy = new ExpirableAndShipabbleProduct("Roomy cheese", 200, 4, 1.0, LocalDate.of(2026, 1, 1));
        
        //Product ScratchingProduct = new ScratchedCard("kart Vodafone", 36, 200);

        cartService.addToCart(tv, 1);
        cartService.addToCart(romy, 2);

        Customer customer = new Customer("Ahmed", "Mokkatem", "+201126724270", ahmedCart);
        customer.setBalance(100000000.4);


        // ------ check out ------ //
        ReceiptPrinter printer = new ReceiptPrinter();
        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService, printer);

        try {
          checkoutService.checkout(ahmedCart, customer);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        



    }
}