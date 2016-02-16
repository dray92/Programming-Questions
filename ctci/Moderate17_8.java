package ctci;

import java.util.Arrays;

/**
 * You are given an array of integers,
 * both positive and negative. Find the 
 * continuous sequence with the largest sum.
 * @author Debosmit
 *
 */
public class Moderate17_8 {
	
	public void printSequence(int[] arr) {
		int curSum = 0, maxSum = 0;
		// Kadane's algorithm
		for(int i = 0 ; i < arr.length ; i++) {
			curSum = Math.max(arr[i], curSum + arr[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		System.out.println("Max: " + maxSum);
	}

	public static void main(String[] args) {
		Moderate17_8 SeqSum = new Moderate17_8();
		int[] arr = {10005,4,1,-9,1,10,11,-2};
		System.out.println(Arrays.toString(arr));
		SeqSum.printSequence(arr);
	}
}
