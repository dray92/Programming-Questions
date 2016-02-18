package randomCode;

import java.math.BigDecimal;
import java.util.*;
class Solution {
    public static int solution(int X) {
        // identical adjacent digits
        // remove one from the group
        // largest possible
        
        int curMax = Integer.MIN_VALUE;
        
        StringBuilder sb = new StringBuilder(""+X);
        
        // identify groups
        for(int i = 1 ; i < sb.length() ; i++) {
            // group
            if(sb.charAt(i-1) == sb.charAt(i)) {
                char ch = sb.charAt(i);
                sb.replace(i, i+1, "");
                curMax = Math.max(curMax, Integer.parseInt(sb.toString()));
                sb.insert(i,ch);
            }   
        }
        return curMax;
    }
    
    public static void main(String[] args) {
    	int n = 223336226;
    	System.out.println(solution(n));
    }
}