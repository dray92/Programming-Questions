package dataStructures;

public class BinaryMinHeap implements PriorityQueue {

	private int[] arr;
	private int size;
	private final int DEFAULT_SIZE = 101;
	private final double LOAD_FACTOR = 0.75;
	
	public BinaryMinHeap() {
		arr = new int[DEFAULT_SIZE];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int findMin() {
		if(isEmpty())
			throw new EmptyHeapException("Queue must have at least one entry");
		return arr[1];
	}

	@Override
	public void insert(int x) {
		
		// check for load on array
		loadCheck();
		
		// increment size of heap
		size++;
		
		// insert value to the end of the data structure
		arr[size] = x;
		
		// percolate up
		int hole = size;
		while(hole > 1 && arr[hole/2] > arr[hole]) {
			int child = arr[hole/2];
			arr[hole/2] = arr[hole];
			arr[hole] = child;
			hole /= 2;
		}
	}

	private void loadCheck() {
		if(size >= (int)(LOAD_FACTOR * arr.length)) {
			int[] newArr = new int[2*arr.length];
			for(int i = 1; i < arr.length ; i++) 
				newArr[i] = arr[i];
			arr = newArr;
		}
	}

	@Override
	public int deleteMin() {
		
		if(isEmpty())
			throw new EmptyHeapException("Queue must have at least one entry");
		
		int retVal = arr[1];
		
		// copying last element to the top
		arr[1] = arr[size];
		
		// percolate down
		int curIndex = 1;
		while(curIndex <= size/2) {
			int childIndex = 2*curIndex;
			if(arr[childIndex] > arr[childIndex+1] && childIndex+1 <= size) 
				childIndex++;
			if(arr[childIndex] > arr[curIndex])
				break;
			int childVal = arr[childIndex];
			arr[childIndex] = arr[curIndex];
			arr[curIndex] = childVal;
			curIndex = childIndex;
		}
		size--;		
		return retVal;
	}

	@Override
	public void makeEmpty() {
		arr = new int[DEFAULT_SIZE];
		size = 0;
		
	}

}
