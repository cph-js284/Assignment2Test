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
    String expectedString;
    int unexpectedInt;
    int[] expectedIntArray;
    boolean expectedBooleanT;
    boolean expectedBooleanF;


    @Before
    public void SetupRunBeforeEachTest(){
        myBank = new Bank();
        rng = new Random();
        expectedString = "Test string";
        unexpectedInt = 34;
        expectedIntArray = new int[]{1,2,3,4,5};
        expectedBooleanT = true;
        expectedBooleanF = false;
    }

    //Exercise 3
    @Test
    public void CalculateInterestBetween0a100(){
        //Assign
        double expected = 45.00 * 0.03;
        account = new Account(45.00);

        //Act
        double actual = myBank.calculateYearlyInterest(account);

        //Assert
        assertEquals(expected, actual, 0.00001);
    }

    //Exercise 3
    @Test
    public void CalculateInterestBetween100a1000(){
        //Assign
        double expected = 500 * 0.05;
        account = new Account(500.00);

        //Act
        double actual = myBank.calculateYearlyInterest(account);
        //Assert
        assertEquals(expected, actual, 0.00001);
    }

    //Exercise 3
    @Test
    public void CalcateleInterestAbove1000(){
        //Assign
        double expected = 1500.00 * 0.07;
        account = new Account(1500.00);

        //Act
        double actual = myBank.calculateYearlyInterest(account);
        //Assert
        assertEquals(expected, actual, 0.00001);
    }

    //Exercise 3
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


    //Exercise 4
    @Test
    public void DiffAssertions8(){
        //Assign - done in @Before

        
        //Assert
        assertEquals("Test string", expectedString);
        assertNotNull(expectedString);

        assertNotEquals( unexpectedInt, 12, "The numbers match");
        assertArrayEquals(expectedIntArray, new int[]{1,2,3,4,5},"The Arrays are not equal");

        assertTrue( expectedBooleanT,"The statement is false");
        assertFalse( expectedBooleanF,"The statement is true");

        assertNotSame(unexpectedInt, expectedString);
        assertNull( nullBank, "Object is not null");
    }

    //Exercise 5
    @Test
    @DisplayName("NewNameTest")    
    public void DiffAssertions8_rename(){
        //Assign - done in @Before
        
        //Assert
        assertEquals("Test string", expectedString);
        assertNotNull(expectedString);

        assertNotEquals( unexpectedInt, 12, "The numbers match");
        assertArrayEquals(expectedIntArray, new int[]{1,2,3,4,5},"The Arrays are not equal");

        assertTrue( expectedBooleanT,"The statement is false");
        assertFalse( expectedBooleanF,"The statement is true");

        assertNotSame(unexpectedInt, expectedString);
        assertNull( nullBank, "Object is not null");
    }

    //Exercise 6
    //@Test
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

    //Exercise 7 - test always fails due to timeout in slowbank object
    //@Test  
    public void DiffAssertions8_MAXduration5Secs(){
        //Assign - done in @Before
        Bank slowBank = new Bank();
        
        assertTimeout(Duration.ofSeconds(5),() ->{
            // the sleeper is placed inside the method "calculateYearlyInterestSLOW" in the bank class
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
        });
    }


    //Exercise 8
    @Test
    @DisplayName("NewNameTest")    
    public void DiffAssertions8_IncludingLambda(){
        //Assign - done in @Before
        
        //Assert
        //following assert contains lambda
        assertEquals("Test string", expectedString, () -> {
            System.out.println("The strings does not match");
            return "The strings does not match";
        });

        assertNotNull(expectedString);
        assertNotNull(expectedString);

        assertNotEquals( unexpectedInt, 12, "The numbers match");
        assertArrayEquals(expectedIntArray, new int[]{1,2,3,4,5},"The Arrays are not equal");

        assertTrue( expectedBooleanT,"The statement is false");
        assertFalse( expectedBooleanF,"The statement is true");

        assertNotSame(unexpectedInt, expectedString);
        assertNull( nullBank, "Object is not null");
    }





    //Exercise 9
    @Test
    public void UsingAssertAllOn8Asserts(){
        //Assign - done in @Before

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

    //Exercise 10 - @Test has been changed to @Disabled
    @Disabled
    public void DISABLED_DiffAssertions8_SameTestsDiffName2() {
        //Assign - done in @Before
        
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

    //Exercise 11 see MyTestRunner.java and the repo markdown for instructions

}
