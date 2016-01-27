package ctci;

import java.util.ArrayList;

public class RecursionDP9_4 {

	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		
		// null subset case
		subsets.add(new ArrayList<Integer>());
		
		for(int i = 0 ; i < set.size() ; i++) {
			int val = set.get(i);	// get the value in the set
			
			// keep track of the new subsets we'll make
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			
			// go over all the existing subsets
			for(ArrayList<Integer> subset: subsets) {
				// create a new subset
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);	// adding contents of existing subset
				newsubset.add(val);			// adding value to create new subset
				moreSubsets.add(newsubset);	// adding new subset to the set of new subsets
			}
			subsets.addAll(moreSubsets);	// adding all new subsets to the old list
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
