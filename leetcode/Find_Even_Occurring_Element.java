package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * Given an integer array, one element occurs 
 * even number of times and all others have 
 * odd occurrences. Find the element with even 
 * occurrences.
 */
public class Find_Even_Occurring_Element {
	
	public int getEvenOccurrent(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		int xor = 0;
		for(int i: arr) {
			set.add(i);
			xor = xor ^ i;
		}
		
		for(int i: set)
			xor = xor ^ i;
		
		return xor;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,3,5,3,7,3,5,7,1,7};
		Find_Even_Occurring_Element ind = new Find_Even_Occurring_Element();
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Even occurent: " + ind.getEvenOccurrent(arr));
	}
}
