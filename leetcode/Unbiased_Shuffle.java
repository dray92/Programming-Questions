package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Unbiased_Shuffle {
	
	private int[] arr;
	
	public Unbiased_Shuffle(int[] arr) {
		this.arr = arr;
	}
	
	public int[] getArray() {
		return arr;
	}
	
	private boolean allUnique() {
		if(arr == null)
			throw new IllegalArgumentException("Array not set");
		Set<Integer> values = new HashSet<Integer>();
		for(int i: arr) 
			if(!values.add(i))
				return false;
		
		return true;
	}
	
	

}
