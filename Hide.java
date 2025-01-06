package com.example.passwordstrength;

public class Hide {
    public String hiddenPassword(String password){
        int length = password.length();
        return "*".repeat(length);
    }
}