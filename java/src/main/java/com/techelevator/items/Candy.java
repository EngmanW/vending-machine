package com.techelevator.items;

public class Candy extends VendingProduct {

//    public VendingProducts(String code, String name, double price) {
//        this.code = code;
//        this.name = name;
//        this.price = price;
//        this.quantity = 5;
//    }

    public Candy (String code, String name, String price) {
        super(code, name, price);
    }

    @Override
    public String purchaseMessage(){
        return ("Munch Munch, Yum!");
    };


}
