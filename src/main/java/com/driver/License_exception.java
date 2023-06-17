package com.driver;

public class License_exception extends Exception{
    License_exception(){
        super("Valid License can not be generated");
    }
}
