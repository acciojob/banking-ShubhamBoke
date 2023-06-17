package com.driver;
import java.security.Key;
import java.util.*;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, 5000);
        if(balance < 5000)
            throw new Balance_exception();

        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        int n = this.tradeLicenseId.length();
        for(int i=0; i<n-1; i++){
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i+1)){
                String new_id = Generate(tradeLicenseId);
                if(new_id.equals(""))
                    throw new License_exception();
                this.tradeLicenseId = new_id;
                break;
            }
        }
    }



    private String Generate(String id){
        int n = id.length();

        TreeMap<Character, Integer> map = new TreeMap<>((a, b) -> {
            return b - a;
        });
        for(int i=0; i<n; i++){
            map.put(id.charAt(i), map.getOrDefault(id.charAt(i), 0)+1);
        }
        char last = '!';
        StringBuilder sb = new StringBuilder();
        while(true){
            for(char c: map.keySet()){
                if(map.get(c) == 0){
                    if(sb.length() == n)
                        return sb.toString();
                    else
                        return "";
                }
                if(c != last){
                    sb.append(c);
                    last = c;
                    map.put(c, map.get(c)-1);
                    break;
                }
            }
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}

class Pair{
    char ch;
    int fr;
    Pair(char ch, int fr){
        this.ch = ch;
        this.fr = fr;
    }
}
