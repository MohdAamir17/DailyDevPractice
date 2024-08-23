package com.learninglog.Aug.Day23;

public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
       String  expression = "-1/2+1/2";
        String string = fractionAddition(expression);
        System.out.println(string);
    }

    public static String fractionAddition(String expression) {
        if (expression.length() == 0) {
            return "0/1";
        }
        int num = 0; // Numerator
        int deNum = 1; // Denominator

        // Regular expression to split the string while retaining the delimiters
        String[] parts = expression.split("(?=[+-])");

        for (String part : parts) {
            String[] fractionParts = part.split("/");
            int currentNum = Integer.parseInt(fractionParts[0]);
            int currentDeNum = Integer.parseInt(fractionParts[1]);

            // Add fractions by finding a common denominator
            num = num * currentDeNum + currentNum * deNum;
            deNum = deNum * currentDeNum;
        }

        // Simplify the fraction
        int gcd = gcd(Math.abs(num), deNum);
        num /= gcd;
        deNum /= gcd;

        return num + "/" + deNum;
    }

    // Helper method to find the Greatest Common Divisor (GCD) using Euclidean algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
