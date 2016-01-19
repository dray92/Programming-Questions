package dataStructures;

import java.util.ArrayList;

public class BinaryMinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	private ArrayList<T> arr;
	private int size;
	private final int DEFAULT_SIZE = 101;
//	private final double LOAD_FACTOR = 0.75;
	
	public BinaryMinHeap() {
		arr = new ArrayList<T>(DEFAULT_SIZE);
		arr.add(0, null);
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
	public T findMin() {
		if(isEmpty())
			throw new EmptyHeapException("Queue must have at least one entry");
		return arr.get(1);
	}

	@Override
	public void insert(T x) {
		
		// increment size of heap
		++size;
		
		arr.ensureCapacity(DEFAULT_SIZE);
		
		// insert value to the end of the data structure
		arr.add(size, x);
		
		// percolate up
		int hole = size;
		while(hole > 1 && ((arr.get(hole/2).compareTo(arr.get(hole))) > 0)) {
			T child = arr.get(hole/2);
			arr.set(hole/2, arr.get(hole));
			arr.set(hole, child);
			hole /= 2;
		}
	}

	@Override
	public T deleteMin() {
		
		if(isEmpty())
			throw new EmptyHeapException("Queue must have at least one entry");
		
		T retVal = arr.get(1);
		
		// copying last element to the top
		arr.set(1, arr.get(size));
		
		// percolate down
		int curIndex = 1;
		while(curIndex <= size/2) {
			int childIndex = 2*curIndex;
			if(childIndex+1 <= size && arr.get(childIndex).compareTo(arr.get(childIndex+1)) > 0) 
				childIndex++;
			if(arr.get(childIndex).compareTo(arr.get(curIndex)) > 0)
				break;
			T childVal = arr.get(childIndex);
			arr.set(childIndex, arr.get(curIndex));
			arr.set(curIndex, childVal);
			curIndex = childIndex;
		}
		size--;		
		return retVal;
	}

	@Override
	public void makeEmpty() {
		arr = new ArrayList<T>();
		size = 0;
	}
}
