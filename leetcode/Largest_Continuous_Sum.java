package leetcode;

import java.util.Arrays;

public class Largest_Continuous_Sum {
	
	public static int findMaxSum(int[] arr) {
		if(arr == null || arr.length < 1)
			throw new IllegalArgumentException();
		
		int currentSum = arr[0], maxSum = arr[0];
		for(int i = 1 ; i < arr.length ; i++) {
			currentSum = Math.max(currentSum+arr[i], arr[i]);
			maxSum = Math.max(maxSum, currentSum);
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] arr = {-11, 2, 5, -4, -13, -5, -2};
		System.out.println(Arrays.toString(arr) + " | Max sum: " + findMaxSum(arr));
	}
}
