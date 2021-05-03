package com.techelevator;

import logging.Logger;

import java.text.NumberFormat;
import java.util.Locale;

public class Balance {
    private double balance;
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

    public Balance (){
        this.balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public String print(){
       return nf.format(this.balance);
    }

    public void addToBalance(int amountAdding){
        this.balance += (double) amountAdding;
        this.print();
    }

    public void subtractFromBalance(String price) {
        //pass in a string price
        //change it to a double
        //subtract from balance
        this.balance -= (Double.parseDouble(price));
    }

    // make this return a string to print out.
    public String cashOut(Logger log){
        log.loggingCashOut(this.balance);
        this.balance *= 100;
        int quarters = (int) (this.balance / 25);
        int dimes = (int) ((this.balance % 25)/ 10);
        int nickels = (int) ( ((this.balance % 25) % 10) / 5);
        this.balance = 0;
        //sout
        return ("Change returned: Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels);

    }

    public boolean isValidBill(int moneyAdded) {
        switch (moneyAdded) {
            case 1:
            case 2:
            case 5:
            case 10:
                this.addToBalance(moneyAdded);
                return true;
            default:
                return false;
        }
    }

}
