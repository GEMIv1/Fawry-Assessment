package com.implementation.model.abstractions;

public abstract class Product {
    
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name){this.name = name;}
    public void setPice(double price){this.price = price;}
    public void setQuantity(int quantity){this.quantity = quantity;}

    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getQuantity(){return quantity;}

    public String increaseStock(int q){
        quantity+=q;
        return "Item added successfully in the stock.\n Name: " + name + ", Quantity: " + quantity;
    }
    public String decreaseStock(int q){
        if(q > quantity){
            return "Enterd quantity is bigger than the stock quantity.\n Stock Quantity: " + quantity;
        }
        quantity -= q;
        return "The remaining quantity of " + name + " is " + quantity;
    }
}
