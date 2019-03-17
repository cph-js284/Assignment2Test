package com.cphjs284;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;
import java.util.Random;

import org.junit.Before;

public class AppTest {

    public Account account;
    public Bank myBank;
    public Bank nullBank;
    public Random rng;

    @Before
    public void SetupRunBeforeEachTest(){
        myBank = new Bank();
        rng = new Random();
        
    }

    @Test
    public void CalculeInterestBetween0a100(){
        //Assign
        double expected = 45.00 * 0.03;
        account = new Account(45.00);

        //Act
        double actual = myBank.calculateYearlyInterest(account);

        //Assert
        assertEquals(expected, actual, 0.00001);
        
    }

    @Test
    public void CalculeInterestBetween100a1000(){
        //Assign
        double expected = 500 * 0.05;
        account = new Account(500.00);

        //Act
        double actual = myBank.calculateYearlyInterest(account);
        //Assert
        assertEquals(expected, actual, 0.00001);
    }
    @Test
    public void CalculeInterestAbove1000(){
        //Assign
        double expected = 1500.00 * 0.07;
        account = new Account(1500.00);

        //Act
        double actual = myBank.calculateYearlyInterest(account);
        //Assert
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void CalculeInterestBelow0(){
        //Assign
        double expected = -1.0;
        account = new Account(-100.00);
        //Act
        double actual = myBank.calculateYearlyInterest(account);
        //Assert
        assertEquals(expected, actual, 0.00001);
    }

//indsæt test for BV. 3 data model for hver ECP.

    @Test
    @DisplayName("NewNameTest")
    public void DiffAssertions8(){
        //Assign
        String expectedString = "Test string";
        int unexpectedInt = 34;
        int[] expectedIntArray = new int[]{1,2,3,4,5};
        boolean expectedBooleanT = true;
        boolean expectedBooleanF = false;

        
        //Assert
        assertEquals("Test string", expectedString, () -> {
            System.out.println("The strings does not match");
            return "The strings does not match";
        });
        assertNotNull(expectedString);

        assertNotEquals( unexpectedInt, 12, "The numbers match");
        assertArrayEquals(expectedIntArray, new int[]{1,2,3,4,5},"The Arrays are not equal");

        assertTrue( expectedBooleanT,"The statement is false");
        assertFalse( expectedBooleanF,"The statement is true");

        assertNotSame(unexpectedInt, expectedString);
        assertNull( nullBank, "Object is not null");
        //assertThat(reason, myBank, IsInstanceOf(Class<Bank>));
    }


    
    //@Test()  //<- this test will not run if annotation is greyed out - test always fails due to timeout in slowbank object
    public void DiffAssertions8_MAXduration5Secs(){
        //Assign
        String expectedString = "Test string";
        int unexpectedInt = 34;
        int[] expectedIntArray = new int[]{1,2,3,4,5};
        boolean expectedBooleanT = true;
        boolean expectedBooleanF = false;
        Bank slowBank = new Bank();
        
        assertTimeout(Duration.ofSeconds(5),() ->{
            double SlowResult = slowBank.calculateYearlyInterestSLOW(account); 
            //Assert
            assertEquals("Test string", expectedString,"The strings does not match" );
            assertNotNull(expectedString);
            assertNotEquals( unexpectedInt, 12, "The numbers match");

            assertArrayEquals(expectedIntArray, new int[]{1,2,3,4,5},"The Arrays are not equal");
            assertTrue( expectedBooleanT,"The statement is false");
            assertFalse( expectedBooleanF,"The statement is true");
            assertNotSame(unexpectedInt, expectedString);
            assertNull( nullBank, "Object is not null");
            //assertThat(reason, myBank, IsInstanceOf(Class<Bank>));
        });
    }

    @Test
    public void ThisMightSkibBasedOnRng()throws TestAbortedException{
        boolean rngBool = rng.nextBoolean();
        System.out.println("Value of random bool : " + rngBool);
        try {
            assumeTrue(rngBool, "Value of random bool : " + rngBool);    
            assertEquals("23", "23");
        } catch (Exception e) {
            System.out.println("Test skipped due to random");
        }
        
        
        
    }







    @Test
    public void UsingAssertAllOn8Asserts(){
        //Assign
        String expectedString = "Test string";
        int unexpectedInt = 34;
        int[] expectedIntArray = new int[]{1,2,3,4,5};
        boolean expectedBooleanT = true;
        boolean expectedBooleanF = false;

        //Assert
        
        assertAll(
            ()->assertEquals("Test string", expectedString,"The strings does not match" ),
            ()->assertNotNull(expectedString),
            ()->assertNotEquals( unexpectedInt, 12, "The numbers match"),
            ()->assertArrayEquals(expectedIntArray, new int[]{1,2,3,4,5},"The Arrays are not equal"),
            ()->assertTrue( expectedBooleanT,"The statement is false"),
            ()->assertFalse( expectedBooleanF,"The statement is true"),
            ()->assertNotSame(unexpectedInt, expectedString),
            ()->assertNull( nullBank, "Object is not null")
        );
    }


    @Disabled
    public void DISABLED_DiffAssertions8_SameTestsDiffName2() {
        //Assign
        String expectedString = "Test string";
        int unexpectedInt = 34;
        int[] expectedIntArray = new int[]{1,2,3,4,5};
        boolean expectedBooleanT = true;
        boolean expectedBooleanF = false;
        
        //Assert
        assertEquals("Test string", expectedString,"The strings does not match" );
        assertNotNull(expectedString);
        assertNotEquals( unexpectedInt, 12, "The numbers match");

        assertArrayEquals(expectedIntArray, new int[]{1,2,3,4,5},"The Arrays are not equal");
        assertTrue( expectedBooleanT,"The statement is false");
        assertFalse( expectedBooleanF,"The statement is true");
        assertNotSame(unexpectedInt, expectedString);
        assertNull( nullBank, "Object is not null");
        //assertThat(reason, myBank, IsInstanceOf(Class<Bank>));
    }
    
}
