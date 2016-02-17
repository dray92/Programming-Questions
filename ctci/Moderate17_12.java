package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, 
 * find all pairs of integers
 * that sum to a specific number.
 * @author Debosmit
 *
 */
public class Moderate17_12 {

	private int[] arr;
	
	public Moderate17_12(int[] arr) {
		this.arr = arr;
	}
	
	public ArrayList<int[]> getTuples(int sum) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < arr.length ; i++) {
			if(map.keySet().contains(sum-arr[i])) {
				list.add(new int[]{arr[i], sum-arr[i]});
			} else {
				map.put(sum-arr[i], arr[i]);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,1,5,3,7,5,9,6,2,6};
		System.out.println(Arrays.toString(arr));
		
		Moderate17_12 Tuples = new Moderate17_12(arr);
		int sum = 8;
		for(int[] tuples: Tuples.getTuples(sum))
			System.out.println(Arrays.toString(tuples));
	}
}
