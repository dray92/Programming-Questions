package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;



/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 * [a, a, b]
 * ['a', 'b', 'b', 'a'] -> ['a', 'b', 'a', 'b'] [b, a, a, b]
 * If you need more classes, simply define them inline.
 */

class Permutations_Without_Adjacent_Equal_Strings {
    // bunch of strings in array
    // return list of arrays that don't hve the same string next to each other
    
    public static void main(String[] args) {
//        String[] arr = new String[]{"a","b","b","a","c","b","b","a","a","a","b","b","c","c","c"};
//        compute(arr);
        
        List<String> st = new LinkedList<String>(Arrays.asList("a", "b", "c", "c"));
        Set<List<String>> results = getPermutations(st, 0, st.size());
        for(List<String> result: results) {
        	boolean valid = true;
        	for(int i = 1 ; i < result.size() ; i++) {
        		if(result.get(i-1).compareTo(result.get(i)) == 0)
        			valid = false;
        	}
        	if(valid)
        		System.out.println(result.toString());
        }
    }
    
    public static Set<List<String>> getPermutations(List<String> strings, int start, int end) {
    	if(start == end)
    		return new HashSet<List<String>>();
    	
    	if(end - start == 1) {
    		Set<List<String>> res = new HashSet<List<String>>();
    		
    		List<String> subList = new ArrayList<String>();
    		for(int i = start ; i < end ; i++)
    			subList.add(strings.get(i));
    		
    		res.add(subList);
    		
    		return res;
    	}
    	
    	Set<List<String>> permutations = getPermutations(strings, start+1, end);
    	String first = strings.get(start);
    	
    	Set<List<String>> result = new HashSet<List<String>>();
    	for(List<String> permutation: permutations) {
    		for(int i = 0 ; i < permutation.size() ; i++) {
    			permutation.add(i, first);
    			result.add(new ArrayList<String>(permutation));
    			permutation.remove(i);
    		}
    		
    		// last
    		permutation.add(first);
    		result.add(new ArrayList<String>(permutation));
    		permutation.remove(permutation.size()-1);
    	}
    	
    	return result;
    }
    
    public static void compute(String[] arr) {
        HashMap<String, Integer> map = getCounts(arr);
        
        Map<Integer, List<String>> inverse = new HashMap<Integer, List<String>>();
        // string -> frequency
        // frequency -> string
        for(String st: map.keySet()) {
            int count = map.get(st);
            if(!inverse.containsKey(count))
            inverse.put(count, new LinkedList<String>());
            
            inverse.get(count).add(st);
        }
        
        System.out.println(inverse.toString());
        
        // ['a', 'b', 'b', 'a', 'c']
        // [ 4 = [a], 1=[b, c, d]]
        // [3=a, 1=bcd]    coll -> [a]
        // [3=a, 1=cd]          -> [ab]
        // [3=a, 1=d]
        
        
        // 4=a 1=bcd   coll =[]
        // 3=a 1=bcd   coll=[a]
        // 3=a 1=cd    coll=[ab]
        
        List<String> coll = new ArrayList<String>();
        int index = 0;
        
        // max value in my keyset
        int max = Integer.MIN_VALUE;
        for(Integer freq: inverse.keySet()) {
            max = Math.max(max, freq);
        }
        
        System.out.println("max freq = " + max);
        
        // if max freq is greater than next highest freq * 2 = problem
        // a a a a b
        
        for(int i = max ; i >= 0 ; i--) {
            System.out.println("i="+i);
            if(!inverse.containsKey(i))
            continue;
            
            List<String> curList = inverse.get(i);
            if(curList.size() == 0)
            continue;
            
            System.out.println(curList.toString());
            
            String top = curList.remove(0);
            ////i = max+1;
            System.out.println(curList.toString());
            
            System.out.println("Top = " + top);
            if(index > 0) {
                System.out.println("coll="+coll.toString());
                if(coll.get(index-1).compareTo(top) == 0) {
                    curList.add(top);
                    continue;
                }
            }
            
            
            
            if(i != 0) {
                // add back to hashmap with freq = freq-1
                if(!inverse.containsKey(i-1))
                inverse.put(i-1, new LinkedList<String>());
                
                inverse.get(i-1).add(top);
            }
            if(i == 0) {
                System.out.println(coll.toString());
                coll = new ArrayList<String>();
                index = 0;
                break;
            }
            i = max+1;
            coll.add(top);
            index++;
            System.out.println("coll="+coll.toString());
            
        }
    }
    
    private static HashMap<String, Integer> getCounts(String[] arr) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String st: arr) {
            
            if(!map.containsKey(st))
            map.put(st, 0);
            
            map.put(st, map.get(st)+1);
        }
        
        return map;
    }
}

