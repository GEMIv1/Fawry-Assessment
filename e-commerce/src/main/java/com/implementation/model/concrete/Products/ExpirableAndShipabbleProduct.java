package com.implementation.model.concrete.Products;

import java.time.LocalDate;

import com.implementation.model.abstractions.Expirable;
import com.implementation.model.abstractions.Product;
import com.implementation.model.abstractions.Shippable;

public class ExpirableAndShipabbleProduct extends Product implements Expirable, Shippable{

    private LocalDate expirationDate;
    private double weight;

    public ExpirableAndShipabbleProduct(String name, double price, int quantity, double weight, LocalDate expirationDate){
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setExpirationDate(LocalDate exDate) {
        this.expirationDate = exDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String getName(){
        return super.getName();
    }


}
