package ctci;

import java.util.Stack;

/**
 * Design a stack, which in addition to
 * push and pop, also has a function findMin() 
 * that returns the minimum element. Everything
 * should operate in O(1) time
 * @author Debosmit
 * @param <T>
 *
 */

public class StackQueue3_2 {

	public class StackNode<T> {
		T val;
		T min;
		
		public StackNode(T val, T min) {
			this.val = val;
			this.min = min;
		}
		
		public String toString() {
			return "" + val;
		}
	}

	private Stack<StackNode<Integer>> stack;
	private int min;
	
	public StackQueue3_2() {
		this.stack = new Stack<StackNode<Integer>>();
		min = Integer.MAX_VALUE;
	}
	
	public void push(int val) {
		if(stack.isEmpty()) {
			stack.push(new StackNode<Integer>(val, val));
			this.min = val;
			return;
		}
		
		StackNode<Integer> prevNode = stack.peek();
		
		// minimum at this node will be the minimum of this 
		// node and the node right before this one
		int curMin = Math.min(val, prevNode.min);
		
		StackNode<Integer> newNode = new StackNode<Integer>(val, curMin);
		
		stack.push(newNode);
		this.min = curMin;		// update current min
	}
	
	public StackNode<Integer> pop() {
		StackNode<Integer> elem = stack.pop();
		
		// update min
		this.min = stack.peek().min;
		
		return elem;
	}
	
	public int getMin() {
		return min;
	}
	
	public StackNode<Integer> peek() {
		return stack.peek();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public String toString() {
		return stack.toString();
	}
	
	public static void main(String[] args) {
		StackQueue3_2 stack = new StackQueue3_2();
		// test exception
//		stack.pop();
		System.out.println("Current min: " + stack.getMin());
		System.out.println("Add 5");
		stack.push(5);
		System.out.println("Add 4");
		stack.push(4);
		System.out.println("Current min: " + stack.getMin());
	}
	
}
