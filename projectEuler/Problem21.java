package projectEuler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem21 {
	
	private static Map<Integer, Integer> sumOfFactorsMap = new HashMap<Integer, Integer>();
	private static final int UPPER = 10000;
	
	static {
		for(int num = 1 ; num <= UPPER ; num++) {
			int sum = 0;
			for(int potentialFactor = 1 ; potentialFactor < num ; potentialFactor++) 
				if(num % potentialFactor == 0)
					sum += potentialFactor;
			sumOfFactorsMap.put(num, sum);
		}
	}
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> amicableNum = new HashSet<Integer>();
		for(Integer val: sumOfFactorsMap.keySet()) {
			if(set.contains(val))
				continue;
			Integer sumOfFactors = sumOfFactorsMap.get(val);
			
			if(val.equals(sumOfFactors))
				continue;

			Integer potentialAmicablePair = sumOfFactorsMap.get(sumOfFactors);
			if( potentialAmicablePair != null && potentialAmicablePair.equals(val) ) {
				set.add(sumOfFactors);
				amicableNum.add(sumOfFactors);
				amicableNum.add(val);
				System.out.println(sumOfFactors + "   " + potentialAmicablePair);
			}
		}
		System.out.println(amicableNum);
		int sum = amicableNum.stream().reduce(0, Integer::sum);
		System.out.println(sum);
	}
}
