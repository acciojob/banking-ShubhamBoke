package com.driver;

public class WithdrawLimit_exception extends Exception{
    WithdrawLimit_exception(){
        super("Maximum Withdraw Limit Exceed");
    }
}
