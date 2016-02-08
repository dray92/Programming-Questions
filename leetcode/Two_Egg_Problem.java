package leetcode;

import java.util.Arrays;

/**
 * A building has 100 floors. One of the floors is the highest 
 * floor an egg can be dropped from without breaking.
 * 
 * If an egg is dropped from above that floor, it will break. 
 * If it is dropped from that floor or below, it will be completely 
 * undamaged and you can drop the egg again.
 * 
 * Given two eggs, find the highest floor an egg can be dropped 
 * from without breaking, with as few drops as possible. 
 * @author Debosmit
 *
 */
public class Two_Egg_Problem {
	private static final int MAX_HEIGHT = 100;
	private int[] floors;
	
	public int getFloorAtWhichEggWillBreak() {
		int getLen = floors.length;
		
		int increment = getIncrementValue(getLen);
		
		// if getLen = 100
		// 14, 27, 39, 50, 60, 69, 77, 84, 90, 95, 99 ... 
		// 14, 13, 12, 11, 10,  9,  8,  7,  6,  5,  4,  3,  2,  1
		
		int numChecks = 0;
		int index = increment--;
		int lastIndex = 0;
		
		while(index < getLen) {
			numChecks++;
			if(willEggBreak(index)) {
				// one egg has broken, time to utilize the other one
				for(int i = lastIndex ; i < index ; i++) {
					numChecks++;
					if(willEggBreak(i)) {
						System.out.println("Number of checks: " + numChecks);
						return i;
					}
				}
				System.out.println("Number of checks: " + numChecks);
				return -1;
			}
			lastIndex = index;
			index += increment--;
		}
		
		System.out.println("Number of checks: " + numChecks);
		return -1;
	}
	
	private int getIncrementValue(int n) {
		// n is the sum of a set of consecutive integers
		// i + (i-1) + (i-2) + ... + 1 = n
		// => i(i+1)/2 = n
		// => i^2 + i - 2*n = 0
		// =>  i = ( (-1) + (1 +- 8n)^.5 ) / 2
		// ignore negative values
		// => i = ( -1 + (1 + 8n)^0.5 ) / 2
		// we need to find this i
		
		return (int)(Math.ceil(Math.sqrt(1 + 8*n)) - 1)/2;
	}

	public boolean willEggBreak(int floor) {
		if(floors == null)
			throw new IllegalArgumentException("Floors array is not initialized");
		if(floor < 0 || floor > floors.length)
			throw new IllegalArgumentException("Entered floor doesn't exist");
		
		return floors[floor] == 1;
	}
	
	public void setFloors(int[] floors) {
		this.floors = floors;
	}
	
	public static void main(String[] args) {
		Two_Egg_Problem FindFloor = new Two_Egg_Problem();
		
		int[] floors = new int[MAX_HEIGHT];
		
		int setFloor = 0 + (int)(Math.random() * MAX_HEIGHT); 
		
		for(int i = setFloor; i < floors.length ; i++) 
			floors[i] = 1;
		
		FindFloor.setFloors(floors);
		System.out.println("Break floor: " + setFloor);
		System.out.println("Floors: " + Arrays.toString(floors));
		int getFloor = FindFloor.getFloorAtWhichEggWillBreak();
		System.out.println("Egg will break at floor: " + getFloor);
	}

}
