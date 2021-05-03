package com.techelevator.items;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChipTest {

        @Test
        public void purchaseMessage_return_Crunch_Crunch_Yum() {
            //Arrange
            Chip chip = new Chip("B2", "Cowtales", "1.50");


            //Act
            String actual = chip.purchaseMessage();
            String expected = "Crunch Crunch, Yum!";

            //Assert
            Assert.assertEquals(expected, actual);
        }


    }