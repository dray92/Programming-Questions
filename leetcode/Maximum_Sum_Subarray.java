package leetcode;

import java.util.Arrays;

public class Maximum_Sum_Subarray {

	public static int findMaxSum(int[] arr) {
		
		int maxHere = 0, maxSoFar = arr[0];
		
		for(int i = 0 ; i < arr.length ; i++) {
			maxHere = Math.max(arr[i], maxHere+arr[i]);
			maxSoFar = Math.max(maxHere, maxSoFar);
		}
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		int[] arr = {-11, 2, 5, -4, -13, -5, -2};
		System.out.println(Arrays.toString(arr) + " | Max value: " + findMaxSum(arr));
	}
}
