package leetcode;

import java.util.Arrays;

/*
 * Given a sorted array of unknown length and a 
 * number to search for, return the index of the 
 * number in the array. Accessing an element out of 
 * bounds throws exception. If the number occurs 
 * multiple times, return the index of any occurrence. 
 * If it isn’t present, return -1.
 */
public class Search_Unknown_Length_Sorted_Array {
	public int getIndex(int[] arr, int n) {
		// binary search starting from index 0
		int index;
		for(index = 0 ; ; index = index == 0 ? 1 : index << 1) {
			try {
				if(arr[index] == n)
					return index;
				if(arr[index] > n) {
					// index of n probably
					// lies between index and index/2
					break;
				}
			} catch(Exception e) {
				// last index tried went overboard
				// possible range for index of n
				// index/2 + 1 to end of array
				break;
			}	
		}
		// index probably in (index/2, index) = [index/2 + 1, index-1]
		int lower = (index >> 1) + 1;	//  lower = index/2 + 1
		
		// open upper bound is the current value of index
		int upper = index - 1;
		int mid = 0; 
		
		while(lower <= upper) {
			try {
				mid = (upper+lower)/2;
				if(arr[mid] == n)
					return mid;
				else if(arr[mid] < n) 
					lower = mid + 1;
				else
					upper = mid - 1;
					
			} catch(Exception e) {
				// need to readjust the upper bound
				upper = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11,13,15,17,19};
		int num = 7;
		Search_Unknown_Length_Sorted_Array ind = new Search_Unknown_Length_Sorted_Array();
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Index of " + num + ": " + ind.getIndex(arr, num));
	}
	
}
