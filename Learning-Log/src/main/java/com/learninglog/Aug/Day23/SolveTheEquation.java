package com.learninglog.Aug.Day23;

public class SolveTheEquation {
    public static void main(String[] args) {
        String equation = "x+5-3+x=6+x-2";
        String string = solveEquation(equation);
        System.out.println(string);
    }

    public static String solveEquation(String equation) {
        // Split the equation into left and right parts at the equals sign
        String[] stringArray = equation.split("=");
        String leftEquation = stringArray[0];
        String rightEquation = stringArray[1];

        // Parse the left and right sides to get coefficients of x and constants
        int[] leftCoefficients = parseEquation(leftEquation);
        int[] rightCoefficients = parseEquation(rightEquation);

        // Coefficients and constants on both sides
        int a = leftCoefficients[0]; // Coefficient of x on the left side
        int b = leftCoefficients[1]; // Constant on the left side
        int c = rightCoefficients[0]; // Coefficient of x on the right side
        int d = rightCoefficients[1]; // Constant on the right side

        // Simplify the equation to ax + b = 0 form
        int coefficientX = a - c;
        int constant = d - b;

        // Determine the solution based on the simplified equation
        if (coefficientX == 0) {
            if (constant == 0) {
                return "Infinite solutions"; // The equation is always true
            } else {
                return "No solution"; // The equation is a contradiction
            }
        } else {
            // One solution exists: x = constant / coefficientX
            return "x=" + (constant / coefficientX);
        }
    }

    // Helper method to parse the equation part and extract coefficients
    private static int[] parseEquation(String equationPart) {
        int coefficientX = 0;
        int constant = 0;

        String[] terms = equationPart.split("(?=[+-])");
        for (String term : terms) {
            if (term.contains("x")) {
                String coefficient = term.replace("x", "");
                if (coefficient.equals("+") || coefficient.equals("")) {
                    coefficientX += 1;
                } else if (coefficient.equals("-")) {
                    coefficientX -= 1;
                } else {
                    coefficientX += Integer.parseInt(coefficient);
                }
            } else {
                constant += Integer.parseInt(term);
            }
        }

        return new int[]{coefficientX, constant};
    }
}
