package com.cphjs284;

/**
 * Bank
 */
public class Bank {

    public double calculateYearlyInterest(Account account){
        //implement - possible to withdraw to begin with
        double tmpBalance = account.GetBalance();
        if(tmpBalance>0 && tmpBalance <100){
            return tmpBalance * 0.03;
        }
        if(tmpBalance>=100 && tmpBalance < 1000){
            return tmpBalance * 0.05;
        }
        if(tmpBalance >=1000 ){
            return tmpBalance * 0.07;
        }

        return -1;
    }
    public double calculateYearlyInterestSLOW(Account account)throws InterruptedException{
        Thread.sleep(8000);
        return -1.0;
    }
    
}