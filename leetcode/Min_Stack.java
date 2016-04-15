package leetcode;

import java.util.Stack;

public class Min_Stack {
	private int curStackMin = Integer.MAX_VALUE;
    private Stack<StackNode> stack = new Stack<StackNode>();
    
    public void push(int x) {
        if(x < curStackMin)
            curStackMin = x;
            
        StackNode node = new StackNode(x, curStackMin);
        stack.push(node);
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            // update curStackMin if stack is not empty
            if(!stack.isEmpty())
                curStackMin = stack.peek().curMin;
            else
                curStackMin = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek().val;
        }
        return -1;
    }

    public int getMin() {
        return curStackMin;
    }
    
    private class StackNode {
        int val, curMin;
        public StackNode(int val, int curMin) {
            this.val = val;
            this.curMin = curMin;
        }
    }
}
