package com.techelevator.items;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void purchaseMessage_return_Munch_Munch_Yum() {
        //Arrange
        Candy candy = new Candy("B2", "Cowtales", "1.50");


        //Act
        String actual = candy.purchaseMessage();
        String expected = "Munch Munch, Yum!";

        //Assert
        Assert.assertEquals(expected, actual);
    }



}