package dataStructures;

import dataStructures.BinaryTree.Node;

public class AVLTree {
	
	private Node root;
	
	public Node getRoot() {
		return this.root;
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
	
	public void delete(int val) {
		root = delete(this.root, val);
	}
	
	public Node delete(Node root, int val) {
		// if value is at the present root
		if(val == root.value)
			return null;
		else if(val < root.value) 
			root.left = delete(root.left, val);
		else 
			root.right = delete(root.right, val);
		
		int balance = balance(root.left, root.right);
		
		if(balance > 1) {	// left subtree violates AVL
			if(height(root.left.left) >= height(root.left.right))
				root = rightRotate(root);
			else {
				root.left = leftRotate(root.left);
                root = rightRotate(root);
			}
		} else if(balance < -1) {	// right subtree violates AVL
			if(height(root.right.right) >= height(root.right.left)){
                root = leftRotate(root);
            }else{
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
		} else {
            root.height = setHeight(root);
            root.size = setSize(root);
        }
        return root;
	}
	
	public void insert(int val) {
		root = insert(this.root, val);
	}
	
	public Node insert(Node root, int val) {
		if(root == null)
			return new Node(val);
		if(val < root.value)
			root.left = insert(root.left, val);
		else if(val > root.value)
			root.right = insert(root.right, val);
		else
			return root; // no duplicates
		
		int balance = balance(root.left, root.right);
		
		if(balance > 1) {	// left subtree violates AVL
			if(height(root.left.left) >= height(root.left.right)){
                root = rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
		} else if(balance < -1) {	// right subtree violates AVL
			if(height(root.right.right) >= height(root.right.left)){
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
		} else {
            root.height = setHeight(root);
            root.size = setSize(root);
        }
        return root;
	}
	
	private int setSize(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.size : 0), (root.right != null ? root.right.size : 0));
    }
	
	private int setHeight(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
    }
	
	private Node leftRotate(Node root){
        Node newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }
    
    private Node rightRotate(Node root){
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }
	
	private int balance(Node rootLeft, Node rootRight){
        return height(rootLeft) - height(rootRight);
    }
	
	private int height(Node root){
        if(root == null)
            return 0;
        else
            return root.height;
    }
}
