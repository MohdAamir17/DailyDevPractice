package com.learninglog.September;

public class FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        int [] chalk = {3,4,1,2};
        int k = 25;
        int chalkReplacerResult = chalkReplacer(chalk, k);
        System.out.println("Find the Student that Will Replace the Chalk : " + chalkReplacerResult);
    }

    public static int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total chalk used in one round
        long totalChalk = 0;
        for (int i = 0; i < chalk.length; i++) {
            totalChalk += chalk[i];
        }

        // Step 2: Find the remaining chalk after complete rounds
        k %= totalChalk;

        // Step 3: Determine which student will need to replace the chalk
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        return 0; // This line should theoretically never be reached
    }
}
