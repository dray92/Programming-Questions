package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues {

private Queue<Integer> queue;
    
    public Implement_Stack_using_Queues() {
        this.queue = new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        topHelper(true);
    }

    private Integer topHelper(boolean removeTop) {
        Queue<Integer> temp = new LinkedList<Integer>();
        
        // if queue is empty
        if(queue.size() == 0)
            throw new IllegalStateException();
            
        // remove all elements except the last one added
        while(queue.size() > 1)
            temp.add(queue.poll());    
            
        // remove last element
        int val = queue.poll();
        
        // replace elements back into the primary queue
        while(temp.size() > 0)
            queue.add(temp.poll());
        
        // add top to the queue if need be
        if(!removeTop)
            queue.add(val);
        
        return val;
    }

    // Get the top element.
    public int top() {
        return topHelper(false);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}
