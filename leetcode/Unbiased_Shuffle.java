package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Unbiased_Shuffle {
	
	private int[] arr;
	
	public Unbiased_Shuffle(int[] arr) {
		this.arr = arr;
	}
	
	public int[] getArray() {
		return arr;
	}
	
	private boolean allUnique() {
		if(arr == null)
			throw new IllegalArgumentException("Array not set");
		Set<Integer> values = new HashSet<Integer>();
		for(int i: arr) 
			if(!values.add(i))
				return false;
		
		return true;
	}
	
	public void shuffle() {
		if(!allUnique()) 
			throw new IllegalArgumentException("If all elements are not "
					+ "unique, probabilty of getting a unique "
					+ "shuffle isn't unbiased.");
		
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			// swap current index with random index
			// in the range [i, arr.length - 1)
			int swapIndex = getRandomInRange(i+1, arr.length - 1);
			
			arr[i] ^= arr[swapIndex];
			arr[swapIndex] ^= arr[i];
			arr[i] ^= arr[swapIndex];
		}
	}
	
	private int getRandomInRange(int minimum, int maximum) {
		Random rand = new Random();
		int randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
		return randomNum;
	}

	public static void main(String[] args) {
		int[] arr = {3,1,2,4,7,5,6,9,8,0};
		Unbiased_Shuffle Shuffler = new Unbiased_Shuffle(arr);
		
		System.out.println("Original array: " + Arrays.toString(arr));
		Shuffler.shuffle();
		System.out.println("Shuffled array: " + Arrays.toString(arr));
	}
}
