package leetcode;

import java.util.Arrays;

/*
 * convert [a1, a2, a3, b1, b2, b3, c1, c2, c3]
 * to [a1, b1, c1, a2, b2, c3, a3, b3, c3]
 */
public class Convert_Array {
	public void convertArray(int arr[]) {
		if(arr.length%3 != 0)
			throw new IllegalArgumentException();
		
		int N = arr.length/3;
		for(int i = 0 ; i < arr.length ; i++) {
			int swap = getIndex(i, N);
			while(swap < i) 
				swap = getIndex(swap, N);
			
			// swap elements
			int temp = arr[swap];
			arr[swap] = arr[i];
			arr[i] = temp;
		}
	}
	
	private int getIndex(int index, int N) {
		return (index%3)*N + (index/3);
	}
	
	public static void main(String[] args) {
		int arr[] = {1,1,1,2,2,2,3,3,3};
		Convert_Array converter = new Convert_Array();
		System.out.println("Old Array: " + Arrays.toString(arr));
		converter.convertArray(arr);
		System.out.println("New Array: " + Arrays.toString(arr));
	}
}
