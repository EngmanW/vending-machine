package com.techelevator;

import com.techelevator.items.*;
import customexceptions.InsufficientFundsException;
import customexceptions.InsufficientQuantity;
import logging.Logger;
import logging.SalesReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingProductsMethods {

    private List<VendingProduct> vendingProducts = new ArrayList<>();
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

    public VendingProductsMethods(){
        loadProducts(vendingProducts);
    }

    public List<VendingProduct> getVendingProducts() {
        return this.vendingProducts;
    }

    private void loadProducts(List<VendingProduct> vendingProducts) {
        //Create File object
        File inputFile = new File("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\vendingmachine.csv");
        //try-catch -- to handle exception if file does not exist
        //Create Scanner
        try (Scanner fileScanner = new Scanner (inputFile))
        {
            while (fileScanner.hasNextLine()){
                //split method
                //Create a string array
                String line = fileScanner.nextLine();
                String[] words = line.split("\\|");
                //	words[3] words[0] = new words[3](words[0], words[1], words[2]);
                switch (words[3]) {
                    case "Chip": {
                        //initialize all the classes
                        vendingProducts.add(new Chip(words[0], words[1], words[2]));
                        break;
                    }
                    case "Candy": {
                        vendingProducts.add(new Candy(words[0], words[1], words[2]));
                        break;
                    }
                    case "Drink": {
                        vendingProducts.add(new Drink(words[0], words[1], words[2]));
                        break;
                    }
                    case "Gum": {
                        vendingProducts.add(new Gum(words[0], words[1], words[2]));
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String invalidProduct(String codeOfSelection, Balance balance, Logger log, SalesReport salesReport) {

        //for each loop
        for (VendingProduct product: vendingProducts) {
            //nested if loop,
            //using an equals method on the code

            if (product.getCode().equals(codeOfSelection)) {
                try {

                    if (Double.parseDouble(product.getPrice()) > balance.getBalance() ) {
                        throw new InsufficientFundsException();
                    }

                    if (product.getQuantity() == 0) {
                        throw new InsufficientQuantity();
                    }

                    //subtract item's price
                    double oldBalance = balance.getBalance();
                    balance.subtractFromBalance(product.getPrice());
                    product.quantityUpdated();
                    log.loggingActionProduct(oldBalance, balance.getBalance(), product.getName(), product.getCode());
                    salesReport.addNewSale(product.getName());
                    return ("\n" + product.getName() + " " + nf.format(Double.parseDouble(product.getPrice()) )+ " " +
                            nf.format(balance.getBalance()) + "\n" + product.purchaseMessage());

                } catch (InsufficientFundsException | InsufficientQuantity e) {
                    return e.getMessage();
                }

            }

        }
        return null;
    }

    public String print(){
        String print = "";
        for (VendingProduct product: this.vendingProducts) {
            print += product.printVendingProduct() + "\n";
        }
        return print;
    }

}
