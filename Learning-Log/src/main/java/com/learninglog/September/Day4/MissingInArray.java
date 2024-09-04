package com.learninglog.September.Day4;

import java.util.Arrays;

public class MissingInArray {
    public static void main(String[] args) {
       int n = 248;
       int arr[] = {59, 190, 213, 78, 95, 51, 228, 88, 60, 217, 100, 227, 111, 152, 36, 210,
                150, 27, 126, 169, 175, 58, 157, 239, 112, 119, 4, 133, 172, 21, 12, 241,
                121, 139, 204, 16, 156, 224, 17, 75, 2, 198, 30, 180, 18, 207, 199, 165,
                10, 56, 41, 236, 99, 138, 32, 15, 49, 245, 114, 216, 247, 77, 122, 208,
                163, 231, 192, 146, 171, 13, 154, 232, 38, 61, 42, 181, 129, 123, 98, 113,
                19, 174, 96, 168, 167, 89, 71, 225, 31, 229, 136, 80, 161, 70, 87, 65, 66,
                92, 8, 201, 132, 116, 11, 191, 86, 143, 243, 220, 203, 202, 110, 149, 193,
                105, 194, 25, 230, 73, 195, 137, 48, 219, 91, 237, 50, 9, 6, 117, 145, 140,
                187, 209, 28, 153, 3, 46, 93, 185, 128, 170, 151, 54, 200, 29, 218, 45, 97,
                84, 221, 102, 1, 108, 20, 52, 101, 246, 109, 79, 130, 53, 211, 235, 72, 82,
                238, 206, 40, 35, 222, 37, 182, 234, 115, 173, 141, 24, 94, 124, 57, 104,
                205, 14, 34, 76, 103, 188, 144, 64, 55, 148, 62, 83, 147, 166, 85, 196,
                159, 177, 134, 106, 233, 162, 240, 223, 183, 186, 212, 107, 118, 7, 215,
                179, 189, 244, 135, 178, 44, 184, 127, 63, 125, 67, 158, 160, 23, 197, 47,
                155, 68, 176, 142, 22, 74, 164, 5, 90, 226, 43, 39, 26, 214, 33, 81, 131,
                69, 242, 120};

        int missingNumber = missingNumber(n, arr);
        System.out.println("Missing Number In Array : " + missingNumber);
    }

    // Note that the size of the array is n-1
    static int missingNumber(int n, int arr[]) {
        // Sort the array
        Arrays.sort(arr);

        // Iterate over the array to find the first missing positive integer
        for (int i = 0; i < arr.length; i++) {
            // If the element doesn't match its expected value (1-based), return the missing number
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers from 1 to maxNumber are present, return maxNumber + 1
        return arr.length + 1;
    }
}
