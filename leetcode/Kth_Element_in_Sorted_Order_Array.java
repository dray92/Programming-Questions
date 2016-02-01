package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers find the kth element in the sorted order 
 * (not the kth distinct element). So, if the array is [3, 1, 2, 1, 4] 
 * and k is 3 then the result is 2, because it’s the 3rd element in sorted 
 * order (but the 3rd distinct element is 3).
 */
public class Kth_Element_in_Sorted_Order_Array {

	// best case: O(N)
	// worst case: O(N^2)
	// selection algorithm
	public int kthLargest_Selection(int[] arr, int left, int right, int k) {
		if(k < 0 || k > arr.length)
			throw new IllegalArgumentException();
		
		if(left == right) 
			return arr[left];
		
		while(true) {
			int pivotIndex = getRandom(left, right);
			pivotIndex = partition1(arr, left, right, pivotIndex);
			int rank = pivotIndex - left + 1;
			if(rank == k) 
				return arr[pivotIndex];
			else if(k < rank)
				return kthLargest_Selection(arr, left, pivotIndex-1, k);
			else 
				return kthLargest_Selection(arr, pivotIndex+1, right, k-rank);
		}
	}
	
	private int partition1(int[] arr, int left, int right, int pivotIndex) {
		// swap arr[right] with arr[pivotIndex]
		int temp = arr[right];
		arr[right] = arr[pivotIndex];
		arr[pivotIndex] = temp;
		
		int pivot = arr[right];
		int swapIndex = left;
		
		for(int i = left; i < right ; i++) {
			if(arr[i] < pivot) {
				temp = arr[i];
				arr[i] = arr[swapIndex];
				arr[swapIndex] = temp;
				swapIndex++;
			}
		}
		temp = arr[right];
		arr[right] = arr[swapIndex];
		arr[swapIndex] = temp;
		return swapIndex;
	}

	private int getRandom(int min, int max) {
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	// worst case: O(N)
	// median of medians algorithm
	/*
	 * Median of medians is a modified version of selection 
	 * algorithm where we improve pivot selection to guarantee 
	 * reasonable good worst case split. The algorithm divides 
	 * the array to groups of size 5 (the last group can be of 
	 * any size < 5). Then calculates the median of each 
	 * group by sorting and selecting the middle element 
	 * (sorting complexity of 5 elements is negligible). 
	 * Finds the median of these medians by recursively 
	 * calling itself, and selects the median of medians as the 
	 * pivot for partition. Then it continues similar to the previous 
	 * selection algorithm by recursively calling the left or right 
	 * subarray depending on the rank of the pivot after partitioning. 
	 * The partition function is slightly different though, 
	 * partition1 function above takes the index of the pivot as 
	 * input, partition2 here takes the value of the pivot as input, 
	 * which is only a slight modification.
	 */
	public int kthLargest_Selection2(int[] arr, int left, int right, int k) {
		int len = right - left + 1;
		
		if(k < 0 || k > len)
			throw new IllegalArgumentException();
		
		if(len <= 5) {
			int[] sortedArr = Arrays.copyOfRange(arr, left, right+1);
			Arrays.sort(sortedArr);
			return sortedArr[k];
		}
		
		int numMedians = len/5;
		int[] medians = new int[numMedians];
		for(int i = 0 ; i < numMedians ; i++) 
			medians[i] = kthLargest_Selection2(arr, left+5*i, left+5*(i+1)-1, 3);
		
		int pivotValue = kthLargest_Selection2(medians, 0, medians.length-1 , (medians.length/2));
		int pivotIndex = partition2(arr, left, right, pivotValue);
		int rank = pivotIndex - left + 1;
		
		if(k <= rank)
			return kthLargest_Selection2(arr, left, pivotIndex, k);
		return kthLargest_Selection2(arr, pivotIndex+1, right, k-rank);
	}
	
	public int partition2(int[] arr, int left, int right, int pivotValue) {
		int swapIndex = left;
		for(int i = left ; i < right+1 ; i++) {
			if(arr[i] < pivotValue) {
				// swap
				int temp = arr[i];
				arr[i] = arr[swapIndex];
				arr[swapIndex] = temp;
				swapIndex++;
			}
		}
		return swapIndex-1;
	}

	public static void main(String[] args) {
		Kth_Element_in_Sorted_Order_Array calculate = new Kth_Element_in_Sorted_Order_Array();
		int arr[] = {1,4,5,2,3,7,0,9,8};
		int k = 5;
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println(k + "th largest element in the array: " + calculate.kthLargest_Selection(arr, 0, arr.length-1, k));
		
		arr = Find_Missing_Element_Arrays.shuffleArray(arr);
		System.out.println("\nArray: " + Arrays.toString(arr));
		System.out.println(k + "th largest element in the array[median of medians]: " + calculate.kthLargest_Selection2(arr, 0, arr.length-1, k));
	}
}
