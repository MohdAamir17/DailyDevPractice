package com.dbd.dev.util;

public class ValidationUtil {
    public static boolean isValidEmail(String email) {
        // Simple email validation regex
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
