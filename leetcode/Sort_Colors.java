package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Sort_Colors {
	public static void sortColors2(int[] nums) {
		
		if(nums == null || nums.length < 2){
	        return;
	    }
		
		TreeMap<Integer, ArrayList<Integer>> map =  new TreeMap<Integer, ArrayList<Integer>>();
		
		for(int i = 0 ; i < nums.length ; i++) {
			int val = nums[i];
			if(!map.containsKey(val)) {
				ArrayList<Integer> set = new ArrayList<Integer>();
				set.add(i);
				map.put(val, set);
			} else {
				ArrayList<Integer> set = map.get(val);
				set.add(i);
			}
		}
		
		int i = 0;
		for(int key: map.keySet()) {
			ArrayList<Integer> set = map.get(key);
			for(int index: set) {
				if(index == i) {
					i++;
					continue;
				}
				nums[i++] = key;
			}
			
		}

    }
	
	public static void sortColors(int[] nums) {
	    if(nums==null||nums.length<2){
	        return;
	    }
	 
	    int[] countArray = new int[3];
	    for(int i=0; i<nums.length; i++){
	        countArray[nums[i]]++;
	    }
	 
	    int j = 0;
	    int k = 0;
	    while(j<=2){
	        if(countArray[j]!=0){
	            nums[k++]=j;
	            countArray[j] = countArray[j]-1;
	        }else{
	            j++;
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 0, 2, 1, 2, 1};
		System.out.println("Array: " + Arrays.toString(nums));
		sortColors(nums);
		System.out.println("Sorted Array: " + Arrays.toString(nums));
	}
}
