package leetcode;

import dataStructures.BinaryTree;
import dataStructures.BinaryTree.Node;


/**
 * Given the root of a binary search tree and 
 * 2 numbers min and max, trim the tree such 
 * that all the numbers in the new tree are between 
 * min and max (inclusive). The resulting tree should 
 * still be a valid binary search tree.
 * @author Debosmit
 *
 */
public class Trim_Binary_Search_Tree {
	public Node trimBST(Node root, int min, int max) {
		if(!(new Binary_Search_Tree_Check().isValid(root)))
			throw new IllegalArgumentException("Invalid BST");
		
		// following a post-order traversal
		root.left = trimBST(root.left, min, max);
		root.right = trimBST(root.right, min, max);
		if(root.value >= min && root.value <= max)
			return root;
		else if(root.value < min)
			return root.right;
		else 
			return root.left;
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3, new Node(1), new Node(4));
		root.right = new Node(7, new Node(6), new Node(10));
		BinaryTree.traverse(root);
		
		Trim_Binary_Search_Tree Trimmer = new Trim_Binary_Search_Tree();
		root = Trimmer.trimBST(root, 3, 7);
		
		BinaryTree.traverse(root);
		

	}
}
