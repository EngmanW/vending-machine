package com.techelevator.items;

public abstract class VendingProduct {
    private String code;
    private String name;
    private String price;
    private int quantity;

    public VendingProduct(String code, String name, String price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = 5;
    }

    public String getCode() {
        return code;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }


    //ABSTRACT METHOD: Purchase message //Tells the class to override the purchase message
   public abstract String purchaseMessage();

    public void quantityUpdated() {
        quantity--;
    }

    // make this return a string to print out
    public String printVendingProduct() {
        if (quantity > 0) {
            //printf("'%15s' %n", "baeldung");
            return (String.format("%-3s %-20s %-5s %-2s", code, name, price, quantity));
        } else {
            return (String.format("%-3s %-20s %-5s %-2s", code, name, price, "SOLD OUT"));
        }
    }
}
