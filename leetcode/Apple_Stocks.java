package leetcode;

import java.util.Arrays;

/**
 * Suppose we could access yesterday's stock prices 
 * as a list, where: 	
 * 		- The indices are the time in minutes past trade 
 * 		  opening time, which was 9:30am local time. 
 * 		- The values are the price in dollars of Apple 
 * 		  stock at that time. 
 * So if the stock cost $500 at 10:30am, 
 * stock_prices_yesterday[60] = 500. 
 * 
 * Write an efficient function that takes 
 * stock_prices_yesterday and returns the 
 * best profit I could have made from 1 purchase 
 * and 1 sale of 1 Apple stock yesterday.
 * 
 * No "shorting"—you must buy before you sell. You may not 
 * buy and sell in the same time step (at least 1 minute must pass). 
 * 
 * @author Debosmit
 *
 */
public class Apple_Stocks {

	public int getMaxProfit(int[] stock_prices_yesterday) {
		
		// make sure we have at least 2 prices
	    if (stock_prices_yesterday.length < 2) {
	        throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
	    }
		
		int maxSum = 0, curSum = stock_prices_yesterday[0];
		
		int startIndex = 0, endIndex = 0;
		
		for(int i = 0 ; i < stock_prices_yesterday.length ; i++) {
			// is adding the value at this index increasing or decreasing the 
			// curSum variable at this value; if it is decreasing curSum, we
			// need to start taking the sum from this index instead.
			curSum = Math.max(stock_prices_yesterday[i], 
					curSum + stock_prices_yesterday[i]);
			// if value at curSum is same as value at curIndex,
			// start pointer must move
			if(curSum == stock_prices_yesterday[i])
				startIndex = i;
			
			endIndex = i;
			// is this curSum greater than whatever is in maxSum?
			maxSum = Math.max(maxSum, curSum);
		}
		System.out.println("Range of times: [" + startIndex + ", " + endIndex + "]");
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,6,1,-17,9,11,15,-15, 10,-5,1};
		Apple_Stocks Calculator = new Apple_Stocks();
		System.out.println("Stock prices: " + Arrays.toString(arr));
		int maxProfit = Calculator.getMaxProfit(arr);
		System.out.println("Max profit: " + maxProfit);
	}
}
