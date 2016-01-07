package leetcode;

import java.util.Arrays;

public class Kth_Largest_Element_in_Array {

	public int kthLargest_Selection(int[] arr, int left, int right, int k) {
		if(k < 0 || k > arr.length)
			return 0;
		
		if(left == right) 
			return arr[left];
		
		while(true) {
			int pivotIndex = getRandom(left, right);
			pivotIndex = partition(arr, left, right, pivotIndex);
			int rank = pivotIndex - left + 1;
			if(rank == k) 
				return arr[pivotIndex];
			else if(k < rank)
				return kthLargest_Selection(arr, left, pivotIndex-1, k);
			else 
				return kthLargest_Selection(arr, pivotIndex+1, right, k-rank);
		}
	}
	
	private int partition(int[] arr, int left, int right, int pivotIndex) {
		// swap arr[right] with arr[pivotIndex]
		int temp = arr[right];
		arr[right] = arr[pivotIndex];
		arr[pivotIndex] = temp;
		
		int pivot = arr[right];
		int swapIndex = left;
		
		for(int i = left; left < right ; i++) {
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

	public static void main(String[] args) {
		Kth_Largest_Element_in_Array calculate = new Kth_Largest_Element_in_Array();
		int arr[] = {1,4,5,2,3,7,0,9,8};
		int k = 5;
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println(k + "th largest element in the array: " + calculate.kthLargest_Selection(arr, 0, arr.length-1, 5));
	}
}
