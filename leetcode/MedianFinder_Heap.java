package leetcode;

import dataStructures.BinaryMinHeap;
import dataStructures.PriorityQueue;

public class MedianFinder_Heap {
	
	private PriorityQueue<Integer> minHeap, maxHeap;
	private int count;
	
	public MedianFinder_Heap() {
		minHeap = new BinaryMinHeap<Integer>();
		maxHeap = new BinaryMinHeap<Integer>();
		count = 0;
	}
	
	// Adds a number into the data structure.
    public void addNum(int num) {
    	if(count%2 == 0) {
    		maxHeap.insert(-1*num);
        	count++;
    		if(minHeap.size() == 0) 
    			return;
    		if(-1*maxHeap.findMin() > minHeap.findMin()) {
    			int toMin = -1*maxHeap.deleteMin();
    			int toMax = minHeap.deleteMin();
    			maxHeap.insert(-1*toMax);
    			minHeap.insert(toMin);
    		}
    	} else {
    		maxHeap.insert(-1*num);
    		int toMin = -1*maxHeap.deleteMin();
    		minHeap.insert(toMin);
    		count++;
    	}
    }
    
    // Returns the median of current data stream
    public double findMedian() {
    	if(count%2 == 0)
    		return (-1*maxHeap.findMin() + minHeap.findMin())/2.0;
    	return -1*maxHeap.findMin();
    }
	
	public static void main(String[] args) {
		MedianFinder_Heap mf = new MedianFinder_Heap();
		mf.addNum(1);
		mf.addNum(5);
		mf.addNum(2);
		mf.addNum(4);
		mf.addNum(3);
		mf.addNum(5);
		System.out.println("Median: " + mf.findMedian());
	}
}
