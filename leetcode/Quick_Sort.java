package leetcode;

import java.util.Arrays;

public class Quick_Sort {

	public void sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public void quickSort(int[] arr, int left, int right) {
		int partitionIndex = partition(arr, left, right);
		if(left < partitionIndex-1)
			quickSort(arr, left, partitionIndex-1);
		if(partitionIndex < right)
			quickSort(arr, partitionIndex, right);
	}

	private int partition(int[] arr, int left, int right) {
		// choose a pivot element the index
		// of which is between left and right
		int pivotValue = arr[(left+right)/2];
		while(left <= right) {
			// get element on the left side of pivotIndex
			// that is greater than pivotValue this
			// element should be moved to the right
			while(arr[left] < pivotValue) 
				left++;
			
			// get element on the right side of pivotIndex
			// that is lesser than pivotValue this 
			// element should be moved to the left
			while(arr[right] > pivotValue)
				right--;
			
			// elements that broke above while loops
			// need to be swapped
			// swap elements and move left, right pointers
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	/**
	 * Swaps elements without using any 
	 * intermediary variables.
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void swap(int[] arr, int left, int right) {
		if(arr[left] == arr[right])
			return;
		arr[left] ^= arr[right];
		arr[right] ^= arr[left];
		arr[left] ^= arr[right];
	}
	
	public static void main(String[] args) {
		Quick_Sort Sorter = new Quick_Sort();
		int[] arr = {3, 4, 2, 5, 1, 7, 6, 9, 8, 0, 19, 81, 71, 65, 99, 191, 153, 132};
		System.out.println("Array before sort: " + Arrays.toString(arr));
		Sorter.sort(arr);
		System.out.println("Array after sort: " + Arrays.toString(arr));
	}
}
