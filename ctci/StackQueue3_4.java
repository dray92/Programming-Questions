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
	
	public void initializeTowers() {
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
		firstTower.add(3);
		firstTower.add(2);
		firstTower.add(1);
	}
	
	public static void main(String[] args) {
		StackQueue3_4 hanoi = new StackQueue3_4();
		hanoi.initializeTowers();
		System.out.println("Towers initialized");
	}
	
}
