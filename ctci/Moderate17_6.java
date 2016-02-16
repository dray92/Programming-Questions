package ctci;

/**
 * Given an array of integers, write a method 
 * to find indices m and n such that if you 
 * sorted elements from m through n, the entire
 * array would be sorted. Minimize n-m to return
 * the smallest subsequence.
 * @author Debosmit
 *
 */
public class Moderate17_6 {

	public Result getBounds(int[] arr) {
		
		// goal: to ensure elements in middle are
		//  - bigger than everything in left
		//  - smaller than everything in right
		
		// get points where things go out of order
		int left = findEndOfLeft(arr), right = findEndOfRight(arr);
		
		// already sorted
		if(left == arr.length - 1)
			return new Result(-1,-1);
		
		// set min and max
		int maxIndx = left, minIndx = right;
		for(int i = left + 1 ; i < right ; i++) {
			if(arr[i] < arr[minIndx])
				minIndx = i;
			
			if(arr[i] > arr[maxIndx])
				maxIndx = i;
		}
		
		// shrink left
		int leftIndx = shrinkLeft(arr, minIndx, left);
		
		// shrink right
		int rightIndx = shrinkRight(arr, maxIndx, right);
		
		
		return new Result(leftIndx, rightIndx);
	}
	
	private int shrinkLeft(int[] arr, int minIndx, int start) {
		int comparison = arr[minIndx];
		for(int i = start-1; i >= 0 ; i--) {
			if(arr[i] <= comparison)
				return i+1;
		}
		return 0;
	}
	
	private int shrinkRight(int[] arr, int maxIndx, int start) {
		int comparison = arr[maxIndx];
		for(int i = start; i < arr.length ; i++) {
			if(arr[i] >= comparison)
				return i-1;
		}
		return arr.length-1;
	}
	
	private int findEndOfLeft(int[] arr) {
		for(int i = 1 ; i < arr.length ; i++) 
			if(arr[i] < arr[i-1]) 
				return i-1;
		return arr.length-1;
	}
	
	private int findEndOfRight(int[] arr) {
		for(int i = arr.length-2 ; i > 0 ; i--) 
			if(arr[i] > arr[i+1]) 
				return i+1;
		return 0;
	}
	
	public class Result {
		int lower, upper;
		
		public Result(int m, int n) {
			this.lower = m;
			this.upper = n;
		}
	}
}
