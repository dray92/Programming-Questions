package ctci;

import java.util.Stack;

/**
 * Sort a stack in ascending order (smallest on top).
 * Can use one stack as auxiliary storage.
 * @author Debosmit
 *
 */
public class StackQueue3_6 extends Stack<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Stack<Integer> stack;
	Stack<Integer> auxStack;
	
	public StackQueue3_6() {
		stack = new Stack<Integer>();
		auxStack = new Stack<Integer>();
	}
	
	public void push(int val) {
		stack.push(val);
	}
	
	public String toString() {
		return stack.toString();
	}
	
	public void sort() {
		while(!stack.isEmpty()) {
			int curTop = stack.pop();
			while(!auxStack.isEmpty() && auxStack.peek() < curTop) 
				stack.push(auxStack.pop());
			
			auxStack.push(curTop);
		}
		stack = auxStack;
		auxStack = new Stack<Integer>();
	}
	
	// returns a new number in [min, max];
	private static int randomWithRange(int min, int max) {
		if(max < min)
			return randomWithRange(max, min);
		
		int range = (max - min) + 1;     
		return (int)((Math.random() * range) + min);
	}
	
	public static void main(String[] args) {
		StackQueue3_6 stack = new StackQueue3_6();
		for(int i = 0 ; i < 10 ; i++) 
			stack.push(i);//randomWithRange(10,99));
		System.out.println("Before sort: " + stack);
		stack.sort();
		System.out.println("After sort:  " + stack);
		
		stack = new StackQueue3_6();
		for(int i = 0 ; i < 10 ; i++) 
			stack.push(randomWithRange(10,99));
		System.out.println("\nBefore sort: " + stack);
		stack.sort();
		System.out.println("After sort:  " + stack);
	}
}
