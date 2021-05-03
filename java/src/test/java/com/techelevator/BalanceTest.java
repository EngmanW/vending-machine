package com.techelevator;

import org.junit.Assert;
import org.junit.Test;


public class BalanceTest {

    @Test
    public void isValidBill_send_in_1_dollar_return_true(){
        //Arrange
        Balance balance = new Balance();
        int moneyAdded = 1;

        //Act
        boolean actual = balance.isValidBill(moneyAdded);
        boolean expected = true;

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isValidBill_send_in_2_dollar_return_false(){
        //Arrange
        Balance balance = new Balance();
        int moneyAdded = 2;

        //Act
        boolean actual = balance.isValidBill(moneyAdded);
        boolean expected = true;

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isValidBill_send_in_20_dollar_return_false(){
        //Arrange
        Balance balance = new Balance();
        int moneyAdded = 20;

        //Act
        boolean actual = balance.isValidBill(moneyAdded);
        boolean expected = false;

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isValidBill_send_in_50_dollar_return_false(){
        //Arrange
        Balance balance = new Balance();
        int moneyAdded = 50;

        //Act
        boolean actual = balance.isValidBill(moneyAdded);
        boolean expected = false;

        //Assert
        Assert.assertEquals(expected, actual);

    }

}