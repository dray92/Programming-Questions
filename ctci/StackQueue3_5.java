package ctci;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implement queue using 2 stacks.
 * @author Debosmit
 * @param <T>
 *
 */
public class StackQueue3_5<T> {
	Stack<T> s1, s2;
	
	public StackQueue3_5() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	// elements in queue is the sum of the 
	// elements of the 2 stacks
	public int size() {
		return s1.size() + s2.size();
	}
	
	// always add to s1
	public void add(T val) {
		s1.push(val);
	}
	
	public T peek() {
		moveElements();
		return s2.peek();
	}
	
	public T remove() {
		moveElements();
		return s2.pop();
	}
	
	// s2 is treated like an aux
	// in s1, the oldest element is the bottom
	// on moving everything to s2, oldest elements
	// are now at the top; while this has elements
	// all the new push operations keep adding
	// to s1
	private void moveElements() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
	}
	
	// returns a new number in [min, max];
	private static byte randomWithRange(int min, int max) {
		if(max < min)
			return randomWithRange(max, min);
		
		int range = (max - min) + 1;     
		return (byte)((Math.random() * range) + min);
	}
	
	public static void main(String[] args) {
		StackQueue3_5<Integer> queue = new StackQueue3_5<Integer>();
		// testing against Java queue
		Queue<Integer> javaQueue = new LinkedList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			int choice = randomWithRange(0, 10);
			if (choice <= 5) { // enqueue
				int element = randomWithRange(1, 10);
				javaQueue.add(element);
				queue.add(element);
				System.out.println("Enqueued " + element);
			} else if (javaQueue.size() > 0) {
				int top1 = javaQueue.remove();
				int top2 = queue.remove();
				if (top1 != top2) { // Check for error
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
				} 
				System.out.println("Dequeued " + top1);
			}
			
			if (javaQueue.size() == queue.size()) {
				if (javaQueue.size() > 0 && javaQueue.peek() != queue.peek()) {
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + javaQueue.peek() + ", " + queue.peek() + " ******");
				}
			} else {
				System.out.println("******* FAILURE - DIFFERENT SIZES ******");
			}
		}
	}
}
