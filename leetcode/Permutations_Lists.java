package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Permutations_Lists {

	public static List<List<Integer>> permutations(List<Integer> es){
	    
	    List<List<Integer>> permutations = new ArrayList<List<Integer>>();
	    
	    if(es.isEmpty())
	    	return permutations;
	    
	    // We add the first element
	    permutations.add(new ArrayList<Integer>(Arrays.asList(es.get(0))));
	    
	    // Then, for all elements e in es (except from the first)
	    for (int i = 1, len = es.size(); i < len; i++) {
	        Integer e = es.get(i);
	        
	        // We take remove each list l from 'permutations'
	        for (int j = permutations.size() - 1; j >= 0; j--) {
	            List<Integer> l = permutations.remove(j);
	            
	            // And adds a copy of l, with e inserted at index k for each position k in l
	            for (int k = l.size(); k >= 0; k--) {
	                ArrayList<Integer> ts2 = new ArrayList<>(l);
	                ts2.add(k, e);
	                permutations.add(ts2);
	            }
	        }
	    }
	    return permutations;
	}
	
	// public static List<List<Integer>> permutations(List<List<Integer>> es) 
	// causes http://stackoverflow.com/questions/1998544/method-has-the-same-erasure-as-another-method-in-type
	public static List<List<String>> permutationsLists(List<String> lists) {
		List<List<String>> permutations = new ArrayList<List<String>>();
	    
	    if(lists.isEmpty())
	    	return permutations;
	    
	    // given strings are also one of the combinations
//	    for(String list: lists)
//	    	permutations.add(list);
	    	
	    
	    return permutations;
	}
	
	public static void printPermutations() {
		
		// convert array to list
	    List<String> list1 = Arrays.asList("A", "B", "C");
	    List<String> list4 = Arrays.asList("J", "K");

	    List<List<String>> lists = new LinkedList<List<String>>();
	    // initial strings also form a permutation
	    lists.add(list1);
	    lists.add(list4);

	    Set<String> combinations = new TreeSet<String>();
	    Set<String> newCombinations;

	    // take out each of the characters from the first list
	    for (String s: lists.remove(0))
	        combinations.add(s);

	    while (!lists.isEmpty()) {
	        List<String> next = lists.remove(0);
	        newCombinations =  new TreeSet<String>();
	        for (String s1: combinations) 
	            for (String s2 : next) 
	              newCombinations.add(s1 + s2);               

	        combinations = newCombinations;
	    }
	    for (String s: combinations)
	        System.out.print(s+" "); 
	    System.out.println();
	}
	
	public static <T> List<List<T>> getCombinations(List<List<T>> lists) {
		List<List<T>> combinations = new ArrayList<List<T>>();
		List<List<T>> newCombinations;
		
		int index = 0;
		
		/*
		 * Idea:
		 * List 1: [1 2]
		 * List 2: [4 5]
		 * List 3: [6 7]
		 * 
		 * Take each element from list 1 and put each element 
		 * in a separate list.
		 * combinations -> [ [1] [2] ]
		 * 
		 * Set up something called newCombinations that will contains a list
		 * of list of integers
		 * Consider [1], then [2]
		 * 
		 * Now, take the next list [4 5] and iterate over integers
		 * [1]
		 * 	add 4	-> [1 4]
		 * 		add to newCombinations -> [ [1 4] ]
		 * 	add 5 	-> [1 5]
		 * 		add to newCombinations -> [ [1 4] [1 5] ]
		 * 
		 * [2]
		 *  add 4	-> [2 4]
		 * 		add to newCombinations -> [ [1 4] [1 5] [2 4] ]
		 * 	add 5 	-> [2 5]
		 * 		add to newCombinations -> [ [1 4] [1 5] [2 4] [2 5] ]
		 * 
		 * point combinations to newCombinations
		 * combinations now looks like -> [ [1 4] [1 5] [2 4] [2 5] ]
		 * Now, take the next list [6 7] and iterate over integers
		 *  ....
		 *  6 will go into each of the lists
		 *  	[ [1 4 6] [1 5 6] [2 4 6] [2 5 6] ]
		 *  7 will go into each of the lists
		 *  	[ [1 4 6] [1 5 6] [2 4 6] [2 5 6] [1 4 7] [1 5 7] [2 4 7] [2 5 7]]
		 *  
		 */
		
		// extract each of the integers in the first list
		// and add each to ints as a new list
		for(T i: lists.get(0)) {
			List<T> newList = new ArrayList<T>();
			newList.add(i);
			combinations.add(newList);
		}
		index++;
		while(index < lists.size()) {
			List<T> nextList = lists.get(index);
			newCombinations = new ArrayList<List<T>>();
			for(List<T> first: combinations) {
				for(T second: nextList) {
					List<T> newList = new ArrayList<T>();
					newList.addAll(first);
					newList.add(second);
					newCombinations.add(newList);
				}
			}
			combinations = newCombinations;
			
			index++;
		}
		
		return combinations;
	}
	
	public static void main(String[] args) {
		printPermutations();
		
		List<Integer> l1 = Arrays.asList(1,2,3);
		List<Integer> l2 = Arrays.asList(4,5);
		List<Integer> l3 = Arrays.asList(6,7);
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		
		List<List<Integer>> combs = getCombinations(lists);
		for(List<Integer> list : combs) {
			System.out.println(list.toString());
		}
		
	}
}
