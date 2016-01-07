package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {
	
	final private int RADIX = 10;
	
	public void sort(int[] arr) {
		// declare and initialize bucket[]
		List<Integer>[] bucket = new ArrayList[RADIX];
		
		for (int i = 0; i < bucket.length; i++)
		    bucket[i] = new ArrayList<Integer>();
		
		// sort
		boolean maxLength = false;
		int tmp = -1, placement = 1;
		  
		while (!maxLength) {
		    maxLength = true;
		    // split input between lists
		    for (int i : arr) {
		      tmp = i / placement;
		      bucket[tmp % RADIX].add(i);
		      if (maxLength && tmp > 0) {
		        maxLength = false;
		      }
		    }
		    
		    // empty lists into input array
		    int a = 0;
		    for (int b = 0; b < RADIX; b++) {
		      for (int i : bucket[b]) {
		        arr[a++] = i;
		      }
		      bucket[b].clear();
		    }
		    // move to next digit
		    placement *= RADIX;
		  }
	}
	
	public static void main(String[] args) {
//		int[] arr = {3, 4, 2, 5, 1, 7, 6, 9, 8, 0, 19, 81, 71, 65, 99, 191, 153, 132};
		int[] arr = {3, 4, 2, 5, 1};
		RadixSort radix = new RadixSort();
		System.out.println("Array: " + Arrays.toString(arr));
		radix.sort(arr);
		System.out.println("Array: " + Arrays.toString(arr));
	}
}
