package com.techelevator;

import logging.Logger;
import logging.SalesReport;
import org.junit.Assert;
import org.junit.Test;

public class VendingProductsMethodsTest {

    @Test
    public void invalidProduct_send_in_codeC5_balance_log() {
        //Initialize a Object
        VendingProductsMethods vendingProductsMethods = new VendingProductsMethods();

        String codeOfSelection = "C4";
        Balance balance = new Balance();
        Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
        SalesReport salesReport = new SalesReport();
        balance.addToBalance(10);

       //Act
       String actual = vendingProductsMethods.invalidProduct(codeOfSelection, balance, log, salesReport);
       //code, name, price
       //C4|Heavy|1.50|Drink
       String expected = "\nHeavy $1.50 $8.50" + "\nGlug Glug, Yum!";

       //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void invalidProduct_send_in_codeA3_balance_log() {
        //Initialize a Object
        VendingProductsMethods vendingProductsMethods = new VendingProductsMethods();

        String codeOfSelection = "A3";
        Balance balance = new Balance();
        Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
        SalesReport salesReport = new SalesReport();

        balance.addToBalance(2);

        //Act
        String actual = vendingProductsMethods.invalidProduct(codeOfSelection, balance, log, salesReport);
        String expected = "Insufficient funds. Please add money.";

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void invalidProduct_send_in_codeA3_balance_log_insufficient_quantity() {
        //Initialize a Object
        VendingProductsMethods vendingProductsMethods = new VendingProductsMethods();

        String codeOfSelection = "A3";
        Balance balance = new Balance();
        Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
        SalesReport salesReport = new SalesReport();

        balance.addToBalance(20);

        while (vendingProductsMethods.getVendingProducts().get(2).getQuantity() > 0){
            vendingProductsMethods.getVendingProducts().get(2).quantityUpdated();
        }


        //Act
        String actual = vendingProductsMethods.invalidProduct(codeOfSelection, balance, log, salesReport);
        String expected = "Product is not available";

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void invalidProduct_send_in_codeF1_balance_log_invalid_code() {
        //Initialize a Object
        VendingProductsMethods vendingProductsMethods = new VendingProductsMethods();

        String codeOfSelection = "F1";
        Balance balance = new Balance();
        Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
        SalesReport salesReport = new SalesReport();

        balance.addToBalance(20);

        //Act
        String actual = vendingProductsMethods.invalidProduct(codeOfSelection, balance, log, salesReport);
        String expected = null;

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void invalidProduct_send_in_codeA_space_1_balance_log_invalid_code() {
        //Initialize a Object
        VendingProductsMethods vendingProductsMethods = new VendingProductsMethods();

        String codeOfSelection = "A 1";
        Balance balance = new Balance();
        Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
        SalesReport salesReport = new SalesReport();

        balance.addToBalance(20);

        //Act
        String actual = vendingProductsMethods.invalidProduct(codeOfSelection, balance, log, salesReport);
        String expected = null;

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void invalidProduct_send_in_codeA_B_space_1_balance_log_invalid_code() {
        //Initialize a Object
        VendingProductsMethods vendingProductsMethods = new VendingProductsMethods();

        String codeOfSelection = "AB 1";
        Balance balance = new Balance();
        Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
        SalesReport salesReport = new SalesReport();

        balance.addToBalance(20);

        //Act
        String actual = vendingProductsMethods.invalidProduct(codeOfSelection, balance, log, salesReport);
        String expected = null;

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void invalidProduct_send_in_code2_C_balance_log_invalid_code() {
        //Initialize a Object
        VendingProductsMethods vendingProductsMethods = new VendingProductsMethods();

        String codeOfSelection = "2C";
        Balance balance = new Balance();
        Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
        SalesReport salesReport = new SalesReport();

        balance.addToBalance(20);

        //Act
        String actual = vendingProductsMethods.invalidProduct(codeOfSelection, balance, log, salesReport);
        String expected = null;

        //Assert
        Assert.assertEquals(expected, actual);

    }
}