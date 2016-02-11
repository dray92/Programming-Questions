package leetcode;

import java.util.Arrays;
import java.util.Random;

public class Merge_Sort {

	public void sort(int[] arr) {
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
	}
	
	public void sortParallel(int[] arr) {
		// get number of cores
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Using " + cores + " cores");
		parallelSort(arr, cores);
	}
	
	private void parallelSort(int[] arr, int threads) {
		if(threads <= 1) {
			mergeSort(arr, new int[arr.length], 0, arr.length-1);
		} else if(arr.length >= 2) {
			int[] left  = Arrays.copyOfRange(arr, 0, arr.length / 2);
			int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
			
			Thread lThread = new Thread(new Sorter(left,  threads / 2));
			Thread rThread = new Thread(new Sorter(right, threads / 2));
			lThread.start();
			rThread.start();
			
			try {
				lThread.join();
				rThread.join();
			} catch (InterruptedException ie) {}
			
			// merge them back together
			merge(left, right, arr);
		}
		
	}
	// Combines the contents of sorted left/right arrays into output array a.
	// Assumes that left.length + right.length == a.length.
	public void merge(int[] left, int[] right, int[] a) {
		int i1 = 0;
		int i2 = 0;
		for (int i = 0; i < a.length; i++) {
			if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
				a[i] = left[i1];
				i1++;
			} else {
				a[i] = right[i2];
				i2++;
			}
		}
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
	
	private static int getInt(int min, int max) {
		Random rand = new Random();
		return min + rand.nextInt((max - min) + 1);
	}
	
	public static void main(String[] args) {
		Merge_Sort Sorter = new Merge_Sort();
		final int arraySize = Integer.MAX_VALUE/100;
		int[] arr = new int[arraySize];
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = getInt(0, arraySize);
		
		int[] copyArr = Arrays.copyOf(arr, arraySize);
//		int[] arr = {3, 4, 2, 5, 1, 7, 6, 9, 8, 0, 19, 81, 71, 65, 99, 191, 153, 132};
		
//		System.out.println("Array before sort: " + Arrays.toString(arr));
		long t1 = System.currentTimeMillis();
		Sorter.sort(arr);
		long t2 = System.currentTimeMillis();
//		System.out.println("Array after sort: " + Arrays.toString(arr));
		System.out.println("Time for single threaded merge sort: " + (t2-t1) + " milliseconds\n");
		
//		System.out.println("Array before sort: " + Arrays.toString(copyArr));
		t1 = System.currentTimeMillis();
		Sorter.sortParallel(copyArr);
		t2 = System.currentTimeMillis();
//		System.out.println("Array after sort: " + Arrays.toString(copyArr));
		System.out.println("Time for multi-threaded threaded merge sort: " + (t2-t1) + " milliseconds\n");
	}
	
	public static class Sorter implements Runnable {
		
		private int[] arr;
		private int threadCount;
		
		public Sorter(int[] arr, int threadCount) {
			this.arr = arr;
			this.threadCount = threadCount;
		}
		
		@Override
		public void run() {
			new Merge_Sort().parallelSort(arr, threadCount);
			
		}
		
	}
}
