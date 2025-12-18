package com.eps.util;

public class InputValidator {

    public static boolean isValidString(String value) {
        return value != null && value.matches("[a-zA-Z ]+");
    }

    public static boolean isValidInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
