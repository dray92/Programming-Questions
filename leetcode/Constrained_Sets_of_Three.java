package leetcode;

import java.util.Arrays;

/*
 * Given a list of integers, unique, positive, find the counts 
 * of sets of three ints where:
 * 		1) n1 != n2 != n3
 * 		2) n1 + n2 + n3 <= t (given)
 */
public class Constrained_Sets_of_Three {
	public static int getNumSets(int[] arr, int t) {
		if(arr == null || arr.length < 3)
			throw new IllegalArgumentException("Bad array");
		
		Arrays.sort(arr);
		
		int count = 0;
		
		for(int left = 0 ; left < arr.length - 2 ; left++) {
			for(int mid = left+1 ; mid < arr.length-1 ; mid++) {
				// with left and mid fixed, move the pointer right
				int right = mid+1;
				while( right < arr.length && (arr[left] + arr[mid] + arr[right]) <= t ) {
					System.out.println(arr[left] + "," + arr[mid] + "," + arr[right]);
					right++;
				}
				count += (right - mid - 1);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{10, 21, 22, 100, 101, 200, 300};
		System.out.println(Arrays.toString(arr) + " | Num sets of 3: " + getNumSets(arr, 500) + "\n\n\n");
		
		arr = new int[]{6, 3, 5, 4};
		System.out.println(Arrays.toString(arr) + " | Num sets of 3: " + getNumSets(arr, 8) + "\n\n\n");
		
		arr = new int[]{2,10,50,15,5};
		System.out.println(Arrays.toString(arr) + " | Num sets of 3: " + getNumSets(arr, 30));
	}

}
