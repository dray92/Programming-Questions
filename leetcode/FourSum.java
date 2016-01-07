package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] num, int target) {
		
		// making HashMap for pairs of values
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                ArrayList<Integer> pair = new ArrayList<Integer>(2);
                pair.add(i);
                pair.add(j);
                if (!dict.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<ArrayList<Integer>>();
                    value.add(pair);
                    dict.put(sum, value);
                } else {
                    ArrayList<ArrayList<Integer>> value = dict.get(sum);
                    value.add(pair);
                }
            }
        }

        // using HashSet to avoid duplication
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        
        // iterate over all the keys in the HashMap
        for (Integer sum : dict.keySet()) {
            ArrayList<ArrayList<Integer>> sumPair = dict.get(sum);
            if (dict.containsKey(target - sum)) {
            	// case where target*2 = sum
				// if target is x and current sum is x/2, then if set has more than one element,
				// they can be used to form a subset, the sum of which will equal target
            	if (target - sum == sum && sumPair.size() == 1)
                    continue;
                
            	ArrayList<ArrayList<Integer>> pairs = dict.get(target - sum);
                
            	// looping for complement of current sum value
                for (ArrayList<Integer> pair1 : sumPair) {
                    for (ArrayList<Integer> pair2 : pairs) {
                        // make sure it is not the same pair.
                        if (pair1 == pair2)
                            continue;
                        
                        // make sure the same index isn't there in both pairs.
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;
                        ArrayList<Integer> tmpResult = new ArrayList<Integer>(4);
                        tmpResult.add(num[pair1.get(0)]);
                        tmpResult.add(num[pair1.get(1)]);
                        tmpResult.add(num[pair2.get(0)]);
                        tmpResult.add(num[pair2.get(1)]);
                        
                        // sort the list and add it into the set.
                        Collections.sort(tmpResult);
                        set.add(tmpResult);
                    }
                }
            }
        }
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        ret.addAll(set);
        return ret;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println("Array: " + Arrays.toString(arr) + " and target: " + target);
		List<List<Integer>> lists = fourSum(arr, target);
		System.out.print("Lists: ");
		for(List<Integer> list: lists)
			System.out.print(Arrays.toString(list.toArray()) + "  ");
	}

}
