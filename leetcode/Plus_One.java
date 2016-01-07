package leetcode;

import java.util.Arrays;

public class Plus_One {
	public static int[] plusOne(int[] digits) {
        
		if(digits.length == 0 || digits == null)
			return null;
		
		int curIndx = digits.length - 1, carry = 1;
		
		
		while(curIndx >= 0) {
			digits[curIndx] += carry;
			if(digits[curIndx] == 10) {
				carry = 1;
				digits[curIndx] = 0;
			} else {
				break;
			}
			if(curIndx == 0 && carry == 1) {
				int[] newDigits = Arrays.copyOf(digits, digits.length+1);
				newDigits[0] = carry;
				return newDigits;
			}
			curIndx--;
		}
		return digits;
    }
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		System.out.println("Original Array: " + Arrays.toString(arr1));
		System.out.println("Array after adding 1: " + Arrays.toString(plusOne(arr1)));
		System.out.println();
		
		int[] arr2 = {1,2,9};
		System.out.println("Original Array: " + Arrays.toString(arr2));
		System.out.println("Array after adding 1: " + Arrays.toString(plusOne(arr2)));
		System.out.println();
		
		int[] arr3 = {9};
		System.out.println("Original Array: " + Arrays.toString(arr3));
		System.out.println("Array after adding 1: " + Arrays.toString(plusOne(arr3)));
		System.out.println();
		
		
	}
	
}
