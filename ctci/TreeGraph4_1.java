package ctci;

import dataStructures.BinaryTree.Node;

/**
 * Check if binary tree is balanced.
 * balanced tree: height of two subtrees
 * of a given node cannot differ by 
 * more than 1.
 * @author Debosmit
 *
 */
public class TreeGraph4_1 {

	public int getHeight(Node root) {
		if(root == null)
			return 0;
		
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public boolean isBalanced(Node root) {
		return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
	}
	
	public static void main(String[] args) {
		Node root = new Node(6, new Node(4, new Node(3), new Node(5)), new Node(10, null, new Node(12, new Node(11), null)));
		TreeGraph4_1 Balance = new TreeGraph4_1();
		System.out.println("Tree is balanced? " + Balance.isBalanced(root));
		
	}
}
