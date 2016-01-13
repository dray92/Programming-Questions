package leetcode;

import dataStructures.BinaryTree.Node;
import java.util.Queue;
import java.util.LinkedList;

/*
 * Given a binary tree of integers, print it in level order. 
 * The output will contain space between the numbers in the same level, 
 * and new line between different levels. This is an illustration of the 
 * breadth first search
 */

public class Tree_Traverse_By_Levels {
	public void printLevels(Node root) {
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int thisCount = 1;	// number of nodes at this level(init to 1 because of root)
		int nextCount = 0;	// number of nodes at next level
		
		// popping nodes till queue is empty
		while(!queue.isEmpty()) {
			Node popped = queue.remove();
			thisCount --;	// one less node left
			
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
			// printing popped value
			System.out.print(popped.value + " ");
			
			// if there are no more nodes left at this level and this level didn't
			// contain all leaves
			if(thisCount == 0 && nextCount > 0) {
				// print the line break to print next level at the next line
				System.out.println();
				
				// number of nodes to print in this level
				thisCount = nextCount;
				
				// number of nodes in next level
				nextCount = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(5, new Node(3, new Node(1), new Node(4)), new Node(7, new Node(6), new Node(8)));
		Tree_Traverse_By_Levels bfsTraverse = new Tree_Traverse_By_Levels();
		bfsTraverse.printLevels(root);
	}
}
