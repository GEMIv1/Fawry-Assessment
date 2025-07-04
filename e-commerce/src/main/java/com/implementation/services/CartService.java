package com.implementation.services;

import com.implementation.model.abstractions.Expirable;
import com.implementation.model.abstractions.Product;
import com.implementation.model.concrete.UserRelated.Cart;

public class CartService {

    private  Cart cart;
    
    public CartService(Cart cart){
        this.cart = cart;
    }

    public void addToCart(Product p, int q){
        
        if(q<0) throw new IllegalStateException("Invalid quantity number");
        else if (q > p.getQuantity())throw new IllegalStateException("Product " + p.getName() + " has only " + p.getQuantity() + "in stock, requested " + q);
        if (p instanceof Expirable) {
            var exp = (Expirable)p;
            if (exp.isExpired())throw new IllegalStateException("Product" + p.getName() +  " expired on " + ((Expirable) p).getExpirationDate());
        }
        cart.add(p, q);
    }

    public void removeFromCart(Product p, int q){
        if(cart.isEmpty()) throw new IllegalArgumentException("The cart is already empty");
        else if(q <= 0 || q>=p.getQuantity()) throw new IllegalArgumentException("Invalid quantity");
        var items = cart.getEntries();
        boolean found = false;
        for(var product : items.entrySet()){
            if(p.equals(product)){
                found = true;
                break;
            }
        }
        if(found) cart.remove(p, q);
        else throw new IllegalArgumentException("Product is not in cart.");
    }
}
