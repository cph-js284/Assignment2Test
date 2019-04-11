package com.cphjs284;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * MyTestRunner
 */
public class MyTestRunner {

   
   public static void main(String[] args) {
      System.out.println("_________________________START RUNNING USING MYTESTRUNNER__________________________");   
      
      Result result = JUnitCore.runClasses(AppTest.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      
      System.out.println("All test passed : " + result.wasSuccessful());

      System.out.println("_________________________DONE RUNNING USING MYTESTRUNNER__________________________");   
   }

}