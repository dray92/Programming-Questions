package ctci;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Implement a stack data structure, wherein,
 * the data structure will comprise of a collection
 * of stacks, each of which has a limited capacity.
 * @author Debosmit
 *
 */
public class StackQueue3_3 {
	
	private List<Stack<Integer>> arr;	// collection of stacks
	
	private int curStack;		// current stack index in list
	private int curStackCapacity;	// number of elements in curStack
	
	public final int maxStackCapacity;	// maximum capacity of stack
	
	private final int numStacks;			// initial number of stacks in list
	
	public StackQueue3_3(int maxStackCapacity) {
		this.maxStackCapacity = maxStackCapacity;
		
		this.numStacks = 3;
		arr = new ArrayList<Stack<Integer>>(numStacks);
		
		for (int i = 0; i < arr.size(); i++) 
			arr.add(new Stack<Integer>());
		
		this.curStack = 0;
	}
	
	public Stack<Integer> getStack(int stackIndex) {
		Stack<Integer> curStack;
		try {
			curStack = arr.get(stackIndex);
			if(curStack == null) {
				curStack = new Stack<Integer>();
				try {
					// on first use, when ArrayList is not
					// set yet, trying to set an index will
					// throw an exception; on future uses,
					// if an index has been previously accessed,
					// but the memory allocated to it throw away,
					// then set will work since that index 
					// currently holds null
					arr.set(stackIndex, curStack);
				} catch(Exception e) {
					arr.add(stackIndex, curStack);
				}
			}
		} catch(Exception e) {
			curStack = new Stack<Integer>();
			arr.add(stackIndex, curStack);
		}
		return curStack;
	}
	
	public StackQueue3_3() {
		this(3);
	}
	
	public void push(int value) {
		Stack<Integer> currentStack;
		// check if need to move to next stack
		if(curStackCapacity < maxStackCapacity) {
			currentStack = getStack(curStack);
			
		}
		else {
			// next stack
			curStack++;	// ptr to next stack
			currentStack = getStack(curStack);
			curStackCapacity = 0;
		}
		currentStack.push(value);
		curStackCapacity++;
	}
	
	public int peek() {
		if(isEmpty())
			throw new IllegalArgumentException("Stack is empty");
		Stack<Integer> currentStack = getStack(curStack);
		return currentStack.peek();
	}
	
	public int pop() {
		if(isEmpty())
			throw new IllegalArgumentException("Stack is empty");
		Stack<Integer> currentStack = getStack(curStack);
		int val = currentStack.pop();
		curStackCapacity--;
		if(curStackCapacity == 0) {
			arr.set(curStack, null);
			curStack--;
			curStackCapacity = maxStackCapacity;
		}
		// tackle empty stack case
		if(curStack == -1) {
			curStack = 0;
			curStackCapacity = 0;
		}
		return val;
	}
	
	public boolean isEmpty() {
		return (curStack == 0 && curStackCapacity == 0);
	}
	
	public static void main(String[] args) {
		StackQueue3_3 stack = new StackQueue3_3();
		for(int i = 0 ; i < 15 ; i++) {
			System.out.println("Adding to stack: " + i);
			stack.push(i);
		}
		
		System.out.println("\nElement at top of stack: " + stack.peek());
		for(int i = 0 ; i < 15 ; i++) 
			System.out.println("Element popped: " + stack.pop());
		
		System.out.println();
		for(int i = 15 ; i >= 0 ; i--) {
			System.out.println("Adding to stack: " + i);
			stack.push(i);
		}
		
		System.out.println("Element at top of stack: " + stack.peek());
		for(int i = 0 ; i < 15 ; i++) 
			System.out.println("Element popped: " + stack.pop());
	}
}
