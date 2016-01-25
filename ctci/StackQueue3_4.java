package ctci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Towers of Hanoi using stacks
 * @author Debosmit
 *
 */
public class StackQueue3_4 {

	public List<Stack<Integer>> towers;
	
	public StackQueue3_4() {
		towers = new ArrayList<Stack<Integer>>();
	}
	
	public void moveTop(int fromTowerIndex, int toTowerIndex) throws Exception {
		Stack<Integer> toTower = towers.get(toTowerIndex);
		int top = towers.get(fromTowerIndex).pop();
		
		// if element present is of lesser value
		if(!toTower.isEmpty() && toTower.peek() <= top)
			throw new Exception("Cannot move top element from "
					+ "tower" + fromTowerIndex + " to tower " + toTowerIndex);
		
		toTower.push(top);
		
	}
	
	public void initializeTowers(int max) {
		for(int i = 0; i < 3 ; i++) {
			Stack<Integer> tower = new Stack<Integer>();
			towers.add(tower);
		}
		Stack<Integer> firstTower = null;
		try {
			firstTower = towers.get(0);
			if(firstTower == null) {
				firstTower = new Stack<Integer>();
				try {
					towers.set(0, firstTower);
				} catch(Exception e) {
					towers.add(firstTower);
				}
			}
		} catch(Exception e) {
			System.err.println("Initialization failed");
			System.exit(0);
		}
		while(max > 0)
			firstTower.add(max--);
	}
	
	public void moveDisks(int numDisks, int destTowerIndex, int bufTowerIndex, 
			int srcTowerIndex) throws Exception {
		if(numDisks > 0) {
			moveDisks(numDisks - 1, bufTowerIndex, destTowerIndex, srcTowerIndex);
			moveTop(srcTowerIndex, destTowerIndex);
			moveDisks(numDisks - 1, destTowerIndex, srcTowerIndex, bufTowerIndex);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		StackQueue3_4 hanoi = new StackQueue3_4();
		int numDisks = 4;
		hanoi.initializeTowers(numDisks);
		System.out.println("Towers initialized");
		System.out.println("Towers: " + hanoi.towers);
		int destTower = 2, bufTower = 1, srcTower = 0;
		hanoi.moveDisks(numDisks, destTower, bufTower, srcTower);
		System.out.println("Towers: " + hanoi.towers);
	}
}
