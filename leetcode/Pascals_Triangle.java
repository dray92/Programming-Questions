package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if(numRows <= 0)
        	return list;
        
        List<Integer> previous = new ArrayList<Integer>();
        previous.add(1);
        list.add(previous);
        
        for(int i = 2 ; i <= numRows ; i++) {
        	List<Integer> newList = new ArrayList<Integer>();
        	newList.add(1);
        	for(int j = 0 ; j < previous.size() - 1 ; j++) 
        		newList.add(previous.get(j) + previous.get(j+1));
        	
        	newList.add(1);
        	list.add(newList);
        	previous = newList;
        }
        return list;
    }
	
	public static void main(String[] args) {
		System.out.println(generate(6));
	}
}
