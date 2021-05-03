package com.techelevator.items;

public class Gum extends VendingProduct {

    public Gum (String code, String name, String price) {
        super(code, name, price);
    }

    @Override
    public String purchaseMessage(){
        return ("Chew Chew, Yum!");
    };

}
