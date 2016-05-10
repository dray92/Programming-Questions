package leetcode;

import java.util.Arrays;

public class Rotate_Array<T> {

	private T[] arr;
	
	public Rotate_Array() {}
	
	public Rotate_Array(T[] arr) {
		this.arr = arr;
	}
	
	public void rotate(int k) {
		k = k % arr.length;
		
		if(k < 0 || arr == null)
			return;
		
		// length of left half
		int leftHalfLen = arr.length - k;
		
		// reverse left half
		reverse(0, leftHalfLen - 1);
		
		// reverse right half
		reverse(leftHalfLen, arr.length - 1);
		
		// reverse entire array
		reverse(0, arr.length - 1);
	}
	
	public T[] getArray() {
		return this.arr;
	}
	
	public void setArray(T[] arr) {
		this.arr = arr;
	}
	
	private void reverse(int left, int right) {
		if(arr == null || arr.length == 1 || (right-left) < 1)
			return;
		
		while(left < right) {
			// swap index left, with index right
			T temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7,8};
		Rotate_Array<Integer> Rotator = new Rotate_Array<Integer>(arr);
		
		System.out.println("Original Array: " + Arrays.toString(arr));
		
		Rotator.rotate(3);
		
		System.out.println("Rotated Array: " + Arrays.toString(arr));
	}
}
