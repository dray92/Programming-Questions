package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Arrays;

public class Array_Pair_Sum {

	public List<List<Integer>> pairSum(int[] arr, int k) {
		if(arr.length < 2)
			return null;
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		
		for(int i = 0 ; i < arr.length ; i++) {
			int valNeeded = k - arr[i];
			if(hash.containsKey(valNeeded)) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(arr[i]);
				list.add(k-arr[i]);
				ret.add(list);
			} else {
				hash.put(arr[i], k-arr[i]);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Array_Pair_Sum pairSum =  new Array_Pair_Sum();
		int arr[] = {2, 4, 6, 8, 1, 3, 5, 7, 9, 0};
		int k = 5;
		List<List<Integer>> lists = pairSum.pairSum(arr, k);
		for(List<Integer> list: lists) 
			System.out.println(Arrays.toString(list.toArray()));
		
	}
}
