package com.techelevator.items;

public class Drink extends VendingProduct {

    public Drink (String code, String name, String price) {
        super(code, name, price);
    }

    @Override
    public String purchaseMessage(){
        return ("Glug Glug, Yum!");
    };
}
