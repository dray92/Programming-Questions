package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_2_Arrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        for(int num: nums1) 
            if(!map.containsKey(num))
                map.put(num, true);
        
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int num: nums2) {
            if(map.containsKey(num) && map.get(num)) {
                list.add(num);
                map.put(num, false);         
            }
        }
        
        int[] arr = new int[list.size()];
        int count = list.size();
        for(int num: list)
            arr[--count] = num;
        return arr;
    }
}
