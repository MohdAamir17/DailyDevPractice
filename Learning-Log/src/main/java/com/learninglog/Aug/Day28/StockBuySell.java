package com.learninglog.Aug.Day28;

public class StockBuySell {
    public static void main(String[] args) {

            int[] prices = {100, 180, 260, 310, 40, 535, 695};
            int n = prices.length;
            maxProfit(prices, n);
            maxProfit2(prices,n);
    }

    // Function to find the maximum profit that can be earned
    public static void maxProfit(int[] prices, int n) {

        int buyDay = 0, sellDay = 0;
        int profit = 0;

        // Traverse through given price array
        for (int i = 1; i < n; i++) {
            // If current price is higher than previous price, calculate the profit
            if (prices[i] > prices[i - 1]) {
                // Sell on current day, and update profit
                profit += prices[i] - prices[sellDay];
                sellDay = i;  // update sell day
            } else {
                // Move to the next potential buy day
                buyDay = i;
                sellDay = i;
            }
        }

        System.out.println("Maximum profit earned: " + profit);
    }

   // Function to find the maximum profit and print buying and selling days
    public static void maxProfit2(int[] prices, int n) {
        if (n == 1) {
            System.out.println("No profit can be made.");
            return;
        }

        int buyDay = 0, sellDay = 0;
        int profit = 0;
        boolean transactionMade = false;

        // Traverse through the array of stock prices
        for (int i = 1; i < n; i++) {
            // If current price is higher than the previous price
            if (prices[i] > prices[i - 1]) {
                sellDay = i;  // Update the sell day

                // If we haven't made any transaction yet, set the buying day
                if (!transactionMade) {
                    buyDay = i - 1;
                    transactionMade = true;
                }
            } else {
                // If we are at the end of a profitable period, print the transaction
                if (transactionMade) {
                    System.out.println("Buy on day: " + buyDay + ", Sell on day: " + sellDay);
                    profit += prices[sellDay] - prices[buyDay];
                    transactionMade = false;
                }
            }
        }

        // If there was a transaction still open at the end
        if (transactionMade) {
            System.out.println("Buy on day: " + buyDay + ", Sell on day: " + sellDay);
            profit += prices[sellDay] - prices[buyDay];
        }

        System.out.println("Maximum profit earned: " + profit);
    }
}
