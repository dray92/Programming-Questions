package leetcode;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Given 2 arrays that have 
 * the same elements except
 * for one, find the missing
 * element.
 * @author Debosmit
 *
 */

public class Find_Missing_Element_Arrays {
	
	public static int getMissingElement(int[] arr, int[] arr2) {
		if(arr.length == arr2.length)
			throw new IllegalArgumentException();
		
		/*
		 * 		XOR Table
		 * 		0 ^ 0 = 0
		 * 		0 ^ 1 = 1
		 * 		1 ^ 0 = 1
		 * 		1 ^ 1 = 0
		 * 
		 * For eg, (0 ^ 5) ^ 5 = 5 ^ 5 = 0
		 * 
		 * Reasoning: List 1: {2,4}
		 * 			  List 2: {2}
		 * 
		 * (2 ^ 4) ^ 2 = 6 ^ 2 = 4 OUR MISSING NUMBER!!!!
		 */
		
		int val = 0;
		
		for(int i : arr)
			val ^= i;
		
		for(int i : arr2) 
			val ^= i;
		
		return val;
	}
	
	
	// Fisher–Yates shuffle
	static int[] shuffleArray(int[] a) {
		int[] arr = Arrays.copyOf(a, a.length);

	    Random rand = ThreadLocalRandom.current();
	    
	    for (int i = arr.length - 1; i > 0; i--) {
	    	int index = rand.nextInt(i + 1);
	    	
	    	// swap
	    	int temp = arr[index];
	    	arr[index] = arr[i];
	    	arr[i] = temp;
	    }
	    
	    return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {-11, 2, 5, -4, -13, -5, -2};
		
		// shuffle array
		int[] arrShuffled = shuffleArray(arr);
		
		// remove random element
		int randomNum = new Random().nextInt(arr.length);
		arrShuffled = ArrayUtils.removeElement(arrShuffled, arrShuffled[randomNum]);
		System.out.println("Original Array: " + Arrays.toString(arr));
		System.out.println("Shuffled Array (removed element): " + Arrays.toString(arrShuffled));
		System.out.println("Missing Element: " + getMissingElement(arr, arrShuffled));
	}

}
