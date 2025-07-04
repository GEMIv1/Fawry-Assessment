package com.implementation.model.concrete.UserRelated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.implementation.model.abstractions.Product;
import com.implementation.model.abstractions.Shippable;

public class Cart {

    private Map<Product, Integer> items;

    public Cart(){
        items = new HashMap<>();
    }

    public void add(Product p, int q){
        items.put(p, q);
        p.decreaseStock(q);
    }

    public void remove(Product p, int q){
        for (Product key : items.keySet()) {
           items.replace(key, items.get(key) - (int) q);
        }
        p.increaseStock(q);
    }

    public boolean  isEmpty(){return items.isEmpty();}

     public Map<Product,Integer> getEntries() {
        return items;
    }

    public double subtotal() {
        double sum = 0;
        for (var e : items.entrySet()) {
            sum += e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }

    public List<Shippable> shippables() {
        List<Shippable> list = new ArrayList<>();
        for (var entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            if (p instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                list.add((Shippable)p);
                }
            }
        }
        return list;
    }


      
}