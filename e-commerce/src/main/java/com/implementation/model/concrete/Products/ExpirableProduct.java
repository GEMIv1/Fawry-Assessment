package com.implementation.model.concrete.Products;

import java.time.LocalDate;

import com.implementation.model.abstractions.Expirable;
import com.implementation.model.abstractions.Product;

// I will assume that the Expirable only products will be any thing conains code like (voucher, scrachedCard, and so on)
public class ExpirableProduct extends Product implements Expirable{

    private LocalDate exDate;
    private String code;

    public ExpirableProduct(String name, String code, double price, int quantity, LocalDate exDate) {
        super(name, price, quantity);
        this.exDate = exDate;
        this.code = code;
    }

    @Override
    public boolean isExpired() {        
        return LocalDate.now().isAfter(exDate);
    }

    @Override
    public void setExpirationDate(LocalDate exDate) {
        this.exDate = exDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return exDate;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    

}
