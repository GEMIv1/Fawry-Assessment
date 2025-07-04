package com.implementation.model.concrete.UserRelated;

public class Customer {
    private double balance;
    private String name;
    private String addr;
    private String phone;
    private Cart cart;

    public Customer(){}

    public Customer(String name, String addr, String phone, Cart cart){
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.cart = cart;
    }

    public void setBalance(double balance){this.balance = balance;}
    public void setName(String name){this.name = name;}
    public void setAddr(String addr){this.addr = addr;}
    public void setPhone(String phone){this.phone = phone;}
    public void setCart(Cart cart){this.cart = cart;}

    public String getName(){return name;}
    public String getAddr(){return addr;}
    public String getPhone(){return phone;}
    public Cart getCart(){return cart;}
    public double getBalance(){return balance;}

    public void debit(double total) {
        balance-=total;
    }


}
