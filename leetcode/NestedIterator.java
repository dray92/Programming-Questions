package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator {
	public interface NestedInteger {

	    // @return true if this NestedInteger holds a single integer, rather than a nested list.
	    public boolean isInteger();

	    // @return the single integer that this NestedInteger holds, if it holds a single integer
	    // Return null if this NestedInteger holds a nested list
	    public Integer getInteger();

	    // @return the nested list that this NestedInteger holds, if it holds a nested list
	    // Return null if this NestedInteger holds a single integer
	    public List<NestedInteger> getList();
	}
	
	private List<Integer> list;
	private int curIndx;

    public NestedIterator(List<NestedInteger> nestedList) {
    	if(nestedList == null)
    		throw new IllegalArgumentException();
        
    	this.list = flatten(nestedList);
        this.curIndx = 0;
    }
    
    private List<Integer> flatten(List<NestedInteger> list) { 
    	List<Integer> result = new ArrayList<Integer>();
    	LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>(list);
    	
    	while(queue.size() > 0) {
    		NestedInteger o = queue.remove();
    		if(o.isInteger())
    			result.add(o.getInteger());
    		else
    			queue.addAll(0, o.getList());
    	}
    	return result;
    }
    
    public Integer next() {
        if(!hasNext())
            return null;
        return this.list.get((curIndx++));        
    }

    public boolean hasNext() {
        return curIndx < list.size();
    }
}

