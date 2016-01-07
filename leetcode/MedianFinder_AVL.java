package leetcode;

import java.util.Stack;

class MedianFinder_AVL {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public int height;

		public Node(int value) {
			this(value, null, null);
		}
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.height = 1;
		}
	}
	
	private int count = 0;
	private Node root;
	
    // Adds a number into the data structure.
    public void addNum(int num) {
    	root = addNum(this.root, num);
    }
    
    private Node addNum(Node root, int num) {
    	if(root == null) {
    		count++;
    		return new Node(num);
    	}
    	else if(num < root.value)
    		root.left = addNum(root.left, num);
    	else if(num >= root.value)
    		root.right = addNum(root.right, num);
    	
    	
    	int balance = balance(root.left, root.right);
    	
    	if(balance > 1) {	// left subtree violates AVL
    		if(height(root.left.left) >= height(root.left.right))
                root = rightRotate(root);
            else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
    	} else if(balance < -1) {	// right subtree violates AVL
    		if(height(root.right.right) >= height(root.right.left))
                root = leftRotate(root);
            else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
    	} else 
            root.height = setHeight(root);
        
    	return root;
    }
    
    private Node leftRotate(Node root){
        Node newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }
    
    private Node rightRotate(Node root){
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }
    
    private int setHeight(Node root){
        if(root == null)
            return 0;
        
        return 1 + Math.max((root.left != null ? root.left.height : 0), 
        		(root.right != null ? root.right.height : 0));
    }
    
    private int balance(Node rootLeft, Node rootRight){
        return height(rootLeft) - height(rootRight);
    }
    
    private int height(Node root) {
        if(root == null)
            return 0;
        return root.height;
    }

    // Returns the median of current data stream
    public double findMedian() {
    	// if even number of values in list,
    	// count/2 and (count/2)+1 needed
    	// else count/2 needed
    	if(root == null)
    		return 0.0;
    	if(count == 1)
    		return root.value;
    	
    	boolean done = false;
    	int index = 0;
    	double sum = 0.0;
    	
    	Stack<Node> stack = new Stack<Node>();
    	Node current = root;
    	while(!done) {
    		if(current != null) {
    			stack.push(current);
    			current = current.left;
    		} else {
    			if(!stack.isEmpty()) {
    				
    				current = stack.pop();
    				index++;
    				if(count % 2 == 0) {
    					if(index == count/2)
    						sum += current.value;
    					if(index == (count/2)+1) {
    						sum = (sum + current.value)/2.0;
    						break;
    					}
    				}
    				else {
    					if(index == (count/2)+1) {
    						sum = current.value;
    						break;
    					}
    				}
    				System.out.print(current.value + " ");
    				current = current.right;
    			}
    			else {
    				done = true;
    			}
    		}
    		
    	}
        return sum;
    }
    
    public static void main(String[] args) {
    	MedianFinder_AVL mf = new MedianFinder_AVL();
//    	mf.addNum(3);
//    	mf.addNum(1);
//    	mf.addNum(4);
//    	mf.addNum(2);
//    	mf.addNum(2);
    	System.out.println("\nMedian = " + mf.findMedian());
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();