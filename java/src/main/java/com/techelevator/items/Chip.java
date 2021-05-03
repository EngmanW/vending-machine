package com.techelevator.items;

public class Chip extends VendingProduct {

    public Chip (String code, String name, String price) {
        super(code, name, price);
    }

    @Override
    public String purchaseMessage(){
        return ("Crunch Crunch, Yum!");
    };
}
