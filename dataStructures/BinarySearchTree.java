package dataStructures;

import dataStructures.BinaryTree.Node;

// duplication not allowed
public class BinarySearchTree {
	
	private Node root;
	
	public Node getRoot() {
		return this.root;
	}
	
	public void insert(Node root, Node node) {
		if(root == null) {
			this.root = node;
			return;
		}
		
		if(node.value < root.value) {
			if(root.left == null) 
				root.left = node;
			else {
				insert(root.left, node);
				return;
			}
		} else if(node.value > root.value) {
			if(root.right == null)
				root.right = node;
			else {
				insert(root.right, node);
				return;
			}
		}
	}
	
	public Node delete(int val) {
		return delete(this.root, val);
	}
	
	public Node delete(Node root, int val) {
		
		if(root == null)
			return root;
		
		else if(val < root.value)
			root.left = delete(root.left, val);
		
		else if(val > root.value)
			root.right = delete(root.right, val);
		
		else {
			// case 1: leaf node
			if(root.left == null && root.right == null)
				root = null;
			
			// case 2: node has 2 children
			else if(root.left != null && root.right != null) {
				//	find minimum in right subtree/ maximum in left subtree
				//	copy the value to the targeted node
				//	delete duplicate from right subtree
				Node min = getMin(root.right);
				root.value = min.value;
				root.right = delete(root.right, min.value);
			}
			
			// case 3: node has one child(either left or right)
			else {
				if(root.left == null) // move to right
					root = root.right;
				else 				  // move to left
					root = root.left;	
			}	
		}
		return root;
	}
	
	public Node getNode(int val) {
		return getNode(root, val);
	}
	
	public Node getNode(Node root, int val) {
		if(root == null || root.value == val)
			return root;
		
		if(val < root.value)
			return getNode(root.left, val);
		else
			return getNode(root.right, val);
		
	}
	
	private Node getMin(Node root) {
		if(root.left != null) 
			return getMin(root.left);
		return root;
	}
}
