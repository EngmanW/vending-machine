package com.techelevator.items;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void purchaseMessage_return_Glug_Glug_Yum() {
        //Arrange
        Drink drink = new Drink("B2", "Cowtales", "1.50");

        //Act
        String actual = drink.purchaseMessage();
        String expected = "Glug Glug, Yum!";

        //Assert
        Assert.assertEquals(expected, actual);
    }


}