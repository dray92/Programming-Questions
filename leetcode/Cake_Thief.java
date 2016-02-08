package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * You are a renowned thief who has recently switched 
 * from stealing precious metals to stealing cakes 
 * because of the insane profit margins. You end up 
 * hitting the jackpot, breaking into the world's 
 * largest privately owned stock of cakes—the vault 
 * of the Queen of England. 
 * 
 * Limited number of types of cake, unlimited supply of each type.
 * 
 * Cake -> public CakeType(weight, value)
 * 
 * You brought a duffel bag that can hold limited 
 * weight, and you want to make off with the most 
 * valuable haul possible.
 *  
 * Write a function maxDuffelBagValue() that takes 
 * an array of CakeType objects and a weight 
 * capacity, and returns the maximum monetary value 
 * the duffel bag can hold. 
 * @author Debosmit
 *
 */
public class Cake_Thief {

	private static class CakeType implements Comparable<CakeType> {

	    int weight;
	    int value;
		double worthToWeightRatio;

	    public CakeType(int weight, int value) {
	        this.weight = weight;
	        this.value  = value;
	        if (weight == 0) {
                if (value == 0) {
                    worthToWeightRatio = 0;
                } else {
                    worthToWeightRatio = Double.MAX_VALUE;
                }
            } else {
                worthToWeightRatio = (double)(value/weight);
            }
	    }
	    
	    public String toString() {
	    	return "(" + weight + " lbs, $" + value + ")";
	    }

		@Override
		public int compareTo(CakeType o) {
			if (this == o) { return 0; }
            if (o == null || !(o instanceof CakeType)) { throw new IllegalArgumentException("Object cannot be null"); }

            double diff = this.worthToWeightRatio - ((CakeType) o).worthToWeightRatio;
            if (diff == 0) { return 0; }
            else if (diff > 0) { return -1; }
            else { return 1; }
		}
	}
	
	public int maxDuffelBagValue(CakeType[] cakes, int maxWeight) {
		return getMaxWorthForWeight_dp_topDown(new ArrayList<CakeType>(Arrays.asList(cakes)), maxWeight);
	}
	
	// This algorithm starts at the final weight and uses recursion to find the optimal worths of lower weights.
    // 1. Sort. Space: O(n/2), Time: O(lg*n)
    // 2. Logic. Space: O(k), Time: O(k + k*n)
    private ArrayList<ArrayList<CakeType>> mMaxWorths;
    public int getMaxWorthForWeight_dp_topDown(ArrayList<CakeType> cakes, final int weightCapacity) {
        if (cakes == null || cakes.isEmpty() || weightCapacity == 0) { return 0; }
        // Sort by worthToWeightRatio.
        Collections.sort(cakes);

        mMaxWorths = new ArrayList<ArrayList<CakeType>>(weightCapacity + 1);
        mMaxWorths.add(0, new ArrayList<CakeType>(0));
        for (int i = 1; i <= weightCapacity; i++) {
            mMaxWorths.add(null);
        }
        ArrayList<CakeType> maxWorthCakes = getMaxWorthCakesForWeight_dp_topDown(cakes, new ArrayList<CakeType>(), weightCapacity);
        return calculateWorthOfCakes(maxWorthCakes);
    }

    public ArrayList<CakeType> getMaxWorthCakesForWeight_dp_topDown(final ArrayList<CakeType> allCakes, ArrayList<CakeType> currentCakes, final int capacityLeft) {
        // Base cases. Return the max worth cakes if it has already been calculated for this weight capacity.
        if (mMaxWorths.size() > capacityLeft && mMaxWorths.get(capacityLeft) != null) { return mMaxWorths.get(capacityLeft); }

        ArrayList<CakeType> maxWorthCakes = null;
        int maxWorth = 0;
        for (CakeType cake : allCakes) {
            if (cake.worthToWeightRatio == 0) { continue; }
//            else if (cake.worthToWeightRatio == Double.MAX_VALUE) { throw new ANSWER_IS_INFINITY_EXCEPTION; }
            if (cake.weight == capacityLeft) {
                mMaxWorths.add(capacityLeft, currentCakes);
                mMaxWorths.get(capacityLeft).add(cake);
            } else if (cake.weight < capacityLeft) {
                ArrayList<CakeType> newCurrentCakes = new ArrayList<CakeType>(currentCakes);
                newCurrentCakes.add(cake);
                ArrayList<CakeType> tempCakes = getMaxWorthCakesForWeight_dp_topDown(allCakes, newCurrentCakes, capacityLeft - cake.weight);
                int tempWorth = calculateWorthOfCakes(tempCakes);
                if (tempWorth > maxWorth) {
                    maxWorth = tempWorth;
                    maxWorthCakes = new ArrayList<CakeType>(tempCakes);
                }
            }
        }
        if (maxWorthCakes == null) {
            maxWorthCakes = new ArrayList<CakeType>(0);
        }
        return maxWorthCakes;
    }
    
    private static int calculateWorthOfCakes(ArrayList<CakeType> cakes) {
        int worth = 0;
        for (CakeType cake : cakes) 
            worth += cake.value;
        
        return worth;
    }
	
	public static void main(String[] args) {
		Cake_Thief Steal = new Cake_Thief();
		
		CakeType[] cakeTypes = new CakeType[]{
		    new CakeType(7, 160),
		    new CakeType(3, 90),
		    new CakeType(2, 15),
		};
		int capacity = 20;
		
		int maxValue = Steal.maxDuffelBagValue(cakeTypes, capacity);
		
		System.out.println("Cakes: " + Arrays.toString(cakeTypes));
		System.out.println("Max value: $" + maxValue);
		
	}

}
