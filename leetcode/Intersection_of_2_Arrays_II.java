package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_2_Arrays_II {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num: nums1) {
            if(!map.containsKey(num))
                map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int num: nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);         
            }
        }
        
        int[] arr = new int[list.size()];
        int count = list.size();
        for(int num: list)
            arr[--count] = num;
        return arr;
    }
}
