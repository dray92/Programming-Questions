package leetcode;

import java.util.Arrays;

public class Merge_Sort {

	public void sort(int[] arr) {
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
	}

	private void mergeSort(int[] arr, int[] helper, int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			mergeSort(arr, helper, start, mid);
			mergeSort(arr, helper, mid+1, end);
			merge(arr, helper, start, mid, end);
		}
	}

	private void merge(int[] arr, int[] helper, int start, int mid, int end) {
		// copy arr[start...mid], arr[mid+1...end]
		// i.e., copying arr[start...end]
		// to helper array
		for(int i = start ; i <= end ; i++)
			helper[i] = arr[i];
		
		int helpLeft = start, helpRight = mid+1, cur = start;
		
		// iterate through helper array compare
		// elements from both arrays and put the
		// smaller element into the original array
		while(helpLeft <= mid && helpRight <= end) {
			if(helper[helpLeft] <= helper[helpRight]) 
				arr[cur] = helper[helpLeft++];
			else 
				arr[cur] = helper[helpRight++];
			cur++;
		}
		
		// copy remaining elements to the original array
		for(int i = 0 ; i <= (mid-helpLeft) ; i++)
			arr[cur+i] = helper[helpLeft+i];
		
		// right side doesn't need copying since it is
		// already at the appropriate indices
	}
	
	public static void main(String[] args) {
		Merge_Sort Sorter = new Merge_Sort();
		int[] arr = {4,2,3,1,5};
		System.out.println("Array before sort: " + Arrays.toString(arr));
		Sorter.sort(arr);
		System.out.println("Array after sort: " + Arrays.toString(arr));
	}
}
