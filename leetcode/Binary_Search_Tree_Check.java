package leetcode;

import dataStructures.BinaryTree;
import dataStructures.BinaryTree.Node;

/**
 * Check if a given tree is a 
 * valid binary search tree.
 * @author Debosmit
 *
 */
public class Binary_Search_Tree_Check {
	public boolean isValid(Node root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValid(Node root, int minValue, int maxValue) {
		if(root == null)
			return true;
		
		if(root.value > minValue && root.value <= maxValue) 
			return isValid(root.left, minValue, root.value) && isValid(root.right, root.value, maxValue);
		
		return false;
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3, new Node(1), new Node(4));
		root.right = new Node(7, new Node(6), new Node(10));
		BinaryTree.traverse(root);
		System.out.println("\nIs Binary tree? " + new Binary_Search_Tree_Check().isValid(root));
		
		root.right.left.value = 3;
		BinaryTree.traverse(root);
		System.out.println("\nIs Binary tree? " + new Binary_Search_Tree_Check().isValid(root));
	}
}
