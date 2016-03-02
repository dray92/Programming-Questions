package ctci;

import java.util.Arrays;

/**
 * Randomly generate a set of m integers from an array 
 * of size n. Each element must have an equal probability
 * of being chosen.
 * @author Debosmit
 *
 */
public class Hard18_3 {

	private int getRandomRange(int min, int max) {
		return min + (int)( Math.random() * (max - min + 1) );
	}
	
	public int[] randomSubset(int[] arr, int m) {
		int[] subset = new int[m];
		for(int i = 0 ; i < m ; i++)
			subset[i] = arr[i];
		
		for(int i = m ; i < arr.length ; i++) {
			int indx = getRandomRange(0, i);
			if(indx < m) {
				subset[indx] = arr[i];
			}
		}
		
		return subset;
	}
	
	public static void main(String[] args) {
		Hard18_3 Subset = new Hard18_3();
		int[] global = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println("Global: " + Arrays.toString(global));
		int[] subset = Subset.randomSubset(global, 4);
		System.out.println("Subset: " + Arrays.toString(subset));
	}
}
