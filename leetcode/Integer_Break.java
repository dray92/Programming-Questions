package leetcode;
import java.util.*;

public class Integer_Break {

	public static int integerBreak2(int n) {
        int max = Integer.MIN_VALUE;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        partition(n, n, new ArrayList<Integer>(), set);
        System.out.println(n + "---" + set);
        
        for(List<Integer> list: set) 
        	max = Math.max(max, getProduct(list));
        System.out.println(max);
        return max;
        
    }
	
	private static int getProduct(List<Integer> list) {
		int product = 1;
		for(int i: list)
			product *= i;
		
		return product;
	}
	
	private static void partition(int n, int max, List<Integer> prefix, Set<List<Integer>> set) {
        if (n == 0) {
        	if(prefix.size() != 1)
        		set.add(new ArrayList<Integer>(prefix));
            return;
        }
  
        for (int i = Math.min(max, n); i >= 1; i--) {
        	prefix.add(i);
            partition(n-i, i, prefix, set);
            prefix.remove(prefix.size()-1);
        }
    }
	
	public static int integerBreak(int n) {
		if(n <= 3)
			return n-1;
		
		if(n%3 == 0) 
			return (int) Math.pow(3, n/3);
		
		if(n%3 == 1)
			return 4 * (int) Math.pow(3, n/3 - 1);
		
		return 6 * (int) Math.pow(3, n/3 - 1); 
	}
    
    public static void main(String[] args) { 
        int N = 2;
        integerBreak2(N);
        System.out.println(integerBreak(N));
        N = 3;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 4;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 5;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 6;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 7;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 8;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 9;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 10;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 11;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 12;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 13;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 14;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
        N = 15;
        integerBreak2(N);
        System.out.println(integerBreak(N));;
    }
}
