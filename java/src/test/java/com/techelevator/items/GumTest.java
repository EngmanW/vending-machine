package com.techelevator.items;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void purchaseMessage_return_Chew_Chew_Yum() {
        //Arrange
        Gum gum = new Gum("B2", "Cowtales", "1.50");


        //Act
        String actual = gum.purchaseMessage();
        String expected = "Chew Chew, Yum!";

        //Assert
        Assert.assertEquals(expected, actual);
    }

}