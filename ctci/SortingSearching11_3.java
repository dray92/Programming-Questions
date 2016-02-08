package ctci;

import java.util.Arrays;

import leetcode.Rotate_Array;

/**
 * Sorted array of n integers. Array has been 
 * rotated an unknown number of times. Find an 
 * element in this array.
 * @author Debosmit
 *
 */
public class SortingSearching11_3 {

	public Integer findElement(int[] arr, int n) {
		return findElement(arr, n, 0, arr.length - 1);
	}

	private Integer findElement(int[] arr, int n, int leftIndx, int rightIndx) {
		
		int midIndx = (leftIndx + rightIndx)/2;
		if(arr[midIndx] == n)
			return midIndx;
		
		if(rightIndx < leftIndx)
			return -1;
		
		/* since array was originally sorted
		 * and then rotated, at least
		 * one half of the array must be in 
		 * increasing order
		 * if arr[leftIndx] is less than arr[midIndx],
		 * the values in the range [leftIndx, midIndx] is 
		 * sorted; the values in the range [midIndx, rightIndx]
		 * might or might not be sorted.
		 * if arr[leftIndx] is greater than arr[midIndx],
		 */
		
		/*
		 * Either left side or right side must be 
		 * ordered. Check to see if which side is
		 * ordered.
		 */
		if(arr[leftIndx] < arr[midIndx]) {			// left side is ordered
			if(arr[leftIndx] <= n && n <= arr[midIndx]) 
				// search left side
				return findElement(arr, n, leftIndx, midIndx - 1);
			else 
				// search right side
				return findElement(arr, n, midIndx + 1, rightIndx);
		} else if(arr[midIndx] < arr[leftIndx]) {	// right side is ordered
			if(arr[midIndx] <= n && n <= arr[rightIndx])
				// search right side
				return findElement(arr, n, midIndx + 1, rightIndx);
			else 
				// search left side
				return findElement(arr, n, leftIndx, midIndx -  1);
		} else if(arr[leftIndx] == arr[midIndx]) {	// left is full of repeats
			if(arr[midIndx] != arr[rightIndx])
				// search right side
				return findElement(arr, n, midIndx + 1, rightIndx);
			else {
				// search both sides
				int result = findElement(arr, n, leftIndx, midIndx - 1);
				if(result == -1)	// couldn't find in left, look in right
					return findElement(arr, n, midIndx + 1, rightIndx);
				return result;
			}
		}
		return -1;
	}
	
	private static int[] IntegerToInt(Integer[] arr) {
		int[] ints = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++)
			ints[i] = Integer.valueOf(arr[i]);
		
		return ints;
	}
	
	public static void main(String[] args) {
		SortingSearching11_3 Search = new SortingSearching11_3();
		
		Integer[] arr = {4, 3, 8, 1, 9, 7, 2, 0, 6, 5};
		Arrays.sort(arr);
		
		System.out.println("Original array: " + Arrays.toString(arr));
		
		// rotate array
		Rotate_Array<Integer> Rotator = new Rotate_Array<Integer>(arr);
		Rotator.rotate(3);
		
		System.out.println("Rotated array: " + Arrays.toString(arr));
		
		int element = 4;
		int index = Search.findElement(IntegerToInt(arr), element);
		
		System.out.println("Index of the value " + element + ": " + index);
	}
}
