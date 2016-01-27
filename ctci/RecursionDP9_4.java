package ctci;

import java.util.ArrayList;

public class RecursionDP9_4 {

	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		
		// null subset case
		subsets.add(new ArrayList<Integer>());
		
		for(int i = 0 ; i < set.size() ; i++) {
			int val = set.get(i);
			
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> subset: subsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);	// adding what was there in the previous list
				newsubset.add(val);
				moreSubsets.add(newsubset);
			}
			subsets.addAll(moreSubsets);
		}
		return subsets;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		int num = 2;
		for(int i = 1 ; i <= num ; i++) 
			set.add(i);
		
		RecursionDP9_4 subsetGen = new RecursionDP9_4();
		
		ArrayList<ArrayList<Integer>> subsets = subsetGen.getSubsets(set);
		
		for(ArrayList<Integer> subset: subsets) 
			System.out.println(subset.toString());
		
		
	}
}
