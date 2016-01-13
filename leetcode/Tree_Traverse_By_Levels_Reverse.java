package leetcode;

import dataStructures.BinaryTree.Node;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

/*
 * This is very similar to the Tree_Traverse_By_Levels 
 * question. We again print the tree in 
 * level order, but now starting from bottom level to 
 * the root.
 */

public class Tree_Traverse_By_Levels_Reverse {
	public void printLevels(Node root) {
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Stack<Integer> levels = new Stack<Integer>();	// keeps track of number of nodes at each level
		Stack<Integer> values = new Stack<Integer>();	// keeps track of all values in the tree
		levels.push(1);	// for the root
		int thisCount = levels.peek();	// number of nodes at this level(init to 1 because of root)
		int nextCount = 0;	// number of nodes at next level
		
		// popping nodes till queue is empty
		while(!queue.isEmpty()) {
			Node popped = queue.remove();
			thisCount--;		// one less node left
			
			// adding popped node's children to the end of the list
			// one child = one more node to print at the next level
			if(popped.left != null) {
				nextCount++;
				queue.add(popped.left);
			}
			if(popped.right != null) {
				nextCount++;
				queue.add(popped.right);
			}
			
			// popped value pushed to the node stack
			values.push(popped.value);
			
			// if there are no more nodes left at this level and this level didn't
			// contain all leaves
			if(thisCount == 0 && nextCount > 0) {
				// pushing the number of nodes at the level onto the level stack
				levels.push(nextCount);
				
				// number of nodes to print in this level
				thisCount = nextCount;
				
				// number of nodes in next level
				nextCount = 0;
			}	
		}
		
		// pop a value from the levels stack to know how
		// many nodes are at that level
		while(!levels.isEmpty()) {
			int num = levels.pop();	// num nodes at that level
			StringBuilder sb = new StringBuilder(num*2);
			// remove num nodes from the values stack
			while(num > 0) {
				sb.insert(0, values.pop() + " ");
				num--;
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(5, new Node(3, new Node(1), new Node(4)), new Node(7, new Node(6), new Node(8)));
		Tree_Traverse_By_Levels_Reverse bfsTraverse = new Tree_Traverse_By_Levels_Reverse();
		bfsTraverse.printLevels(root);
	}
}
