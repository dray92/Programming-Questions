package ctci;

import java.lang.reflect.Array;

/** 
 * Use single array to implement three stacks
 * @author Debosmit
 *
 */
public class StackQueue3_1<T> {
	int stackSize;			// size of each stack
	int numStacks;			// number of stacks
	T[] arrStack;			// store the elements
	int[] stackPointers;	// keep track of top element
	
	public StackQueue3_1(Class<T> c, int stackSize, int numStacks) {
        // Use Array native method to create array
        // of a type only known at run time
        @SuppressWarnings("unchecked")
        final T[] arr = (T[]) Array.newInstance(c, stackSize*numStacks);
        this.arrStack = arr;
        
        // initialize stackPointers to -1
        stackPointers = new int[numStacks];
        for(int i = 0 ; i < numStacks ; i++)
        	stackPointers[i] = -1;
        
        this.stackSize = stackSize;
        this.numStacks = numStacks;
    }
	
	public void push(T val, int numStack) {
		// check if stack is already full
		if(isFull(numStack))
			throw new IllegalArgumentException("Stack " + numStack + " is full");
		
		// increment index for new value
		stackPointers[numStack]++;
		arrStack[getStackTopIndex(numStack)] = val;
		
	}
	
	public T pop(int numStack) {
		T val = peek(numStack);
		
		// nullify the index of the top value
		arrStack[getStackTopIndex(numStack)] = null;
		
		// reduce pointer
		stackPointers[numStack]--;
		
		return val;
	}
	
	public T peek(int numStack) {
		if(isEmpty(numStack))
			throw new IllegalArgumentException("Stack " + numStack + " is empty");
		
		return arrStack[getStackTopIndex(numStack)];
	}
	
	public boolean isFull(int numStack) {
		return stackPointers[numStack] == stackSize-1;
	}
	
	public boolean isEmpty(int numStack) {
		if(numStack < 0 || numStack >= stackPointers.length)
			throw new IllegalArgumentException("Stack " + numStack + " isn't one of the stacks");
		return stackPointers[numStack] == -1;
	}
	
	private int getStackTopIndex(int numStack) {
		return stackSize*numStack + stackPointers[numStack];
	}
	
	public static void main(String[] args) {
		// elements in stack: 5
		// number of stacks: 2
		int numStacks = 2, stackSize = 5;
		StackQueue3_1<String> stack = new StackQueue3_1<String>(String.class, stackSize, numStacks);
		
		System.out.println("Added to stack 0: " + "Abby");
		stack.push("Abby", 0);
		System.out.println("Added to stack 0: " + "Bob");
		stack.push("Bob", 0);
		
		System.out.println("\nAdded to stack 1: " + "Abby");
		stack.push("Abby", 1);
		System.out.println("Added to stack 1: " + "Bob");
		stack.push("Bob", 1);
		System.out.println("Added to stack 1: " + "Carl");
		stack.push("Carl", 1);
		System.out.println("Added to stack 1: " + "Dick");
		stack.push("Dick", 1);
		System.out.println("Added to stack 1: " + "Evan");
		stack.push("Evan", 1);
		System.out.println("Added to stack 1: " + "Frank");
		stack.push("Frank", 1);
		
		System.out.println("\nPeeking from top of stack 0: " + stack.peek(0));
		String val = stack.pop(0);			// stack was initialized to hold Strings
		System.out.println("Value popped from stack 0: " + val);
		System.out.println("Top of stack 0: " + stack.peek(0));
		
		System.out.println("\nPeeking from top of stack 1: " + stack.peek(1));
		val = stack.pop(1);			// stack was initialized to hold Strings
		System.out.println("Value popped from stack 1: " + val);
		System.out.println("Top of stack 1: " + stack.peek(1));
	}
}
