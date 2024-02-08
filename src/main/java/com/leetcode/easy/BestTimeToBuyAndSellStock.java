package com.leetcode.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i,
 *
 * If you were only permitted to complete at most one transaction (i.e. buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one
 *
 * Example 1:
 *  Input: [7, 1, 5, 3, 6, 4]
 *  Output: 5
 *  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *
 * Example 2:
 *  Input: [7, 6, 4, 3, 1]
 *  Output: 0
 *  Explanation: In this case, no transaction is done, i.e. max profit = 0
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int x=0; x<prices.length; x++) {
            int stock = prices[x];
            for (int y=x+1; y<prices.length; y++) {
                if (stock < prices[y]) {
                    profit = Math.max(profit, prices[y] - stock);
                }
            }
        }

        return profit;
    }

    // [7, 1, 5, 3, 6, 4]
    public static int maxProfitEnhanced(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int x=0; x<prices.length; x++) {
            int price = prices[x];
            if (price < min) {
                min = price;
            } else if (price - min > profit) {
                profit = price - min;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitEnhanced(prices));

        int[] prices2 = {7, 9, 1, 3, 5, 4, 24};
        System.out.println(maxProfitEnhanced(prices2));
    }

}
