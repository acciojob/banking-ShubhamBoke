package com.driver;

public class Main {
    public static void main(String[] args) {
        try{
            CurrentAccount ca = new CurrentAccount("Shubham", 5000, "AAB");
            ca.validateLicenseId();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}