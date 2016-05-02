package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums) {
        	if(!map.containsKey(i))
        		map.put(i, 0);
        	map.put(i, map.get(i) + 1);
        }
        
        // idea is to do a priority queue with a custom comparator that
        // will compare based on frequency in map, rather than natural ordering
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new MyComparator(map));
        
        for(int i: map.keySet()) {
        	pq.add(i);
        	// if size of queue is ever greater than k, 
        	// get rid of smallest frequency value
        	if(pq.size() > k)
        		pq.poll();
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(pq.poll());
        for(int num: pq)
        	result.add(0, num);
        
        return	result; 
    }
	
	private class MyComparator implements Comparator<Integer> {

		private Map<Integer, Integer> map;

		public MyComparator(Map<Integer, Integer> map) {
			this.map = map;
		}
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(map.get(o1) < map.get(o2))
				return -1;
			if(map.get(o1) > map.get(o2))
				return +1;
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,1,1,2,2,3};
		System.out.println(new Top_K_Frequent_Elements().topKFrequent(arr, 2));
	}
}
