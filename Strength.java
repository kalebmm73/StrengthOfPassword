package com.example.passwordstrength;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Strength {
    public String getStrength(String password) {
        int strength = 0;
        boolean containsLower = false;
        boolean containsUpper = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;
        Set<Character> set = new HashSet<Character>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));
        for (char i : password.toCharArray()) {
            if (Character.isLowerCase(i)) {
                containsLower = true;
                strength++;
            }
            if (Character.isUpperCase(i)) {
                containsUpper = true;
                strength++;
            }
            if (Character.isDigit(i)) {
                containsDigit = true;
                strength++;
            }
            if (set.contains(i)) {
                containsSpecialChar = true;
                strength++;
            }
        }
        if (containsLower && containsUpper && containsDigit && containsSpecialChar && strength > 12)
            return "Strong";
        else if (containsLower && containsUpper && containsDigit && containsSpecialChar && strength < 12)
            return "Moderate";
        else
            return "Weak";
    }
}