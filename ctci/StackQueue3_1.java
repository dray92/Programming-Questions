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
        stackPointers = new int[numStacks];
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
		return getStackTopIndex(numStack) == stackSize;
	}
	
	public boolean isEmpty(int numStack) {
		if(numStack < 0 || numStack >= stackPointers.length)
			throw new IllegalArgumentException("Stack " + numStack + " isn't one of the stacks");
		return stackPointers[numStacks] == -1;
	}
	
	private int getStackTopIndex(int numStack) {
		return stackSize*numStack + stackPointers[numStack];
	}
	
	public static void main(String[] args) {
		StackQueue3_1<String> stack = new StackQueue3_1<String>(String.class, 5, 5);
		
	}
}
