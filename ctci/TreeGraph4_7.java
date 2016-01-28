package ctci;

import dataStructures.BinaryTree.Node;

/**
 * Find first common ancestor of two nodes in 
 * a binary tree
 * @author Debosmit
 *
 */
public class TreeGraph4_7 {

	public Node getFirstCommonAncestor(Node root, Node n1, Node n2) {
		if(!isInTree(root, n1) || !isInTree(root, n2))
			return null;
		
		return getFirstCommonAncestorHelper(root, n1, n2);
	}
	
	private Node getFirstCommonAncestorHelper(Node root, Node n1, Node n2) {
		if(root == null)
			return null;
		
		boolean n1OnLeft = isInTree(root.left, n1);
		boolean n2OnLeft = isInTree(root.left, n2);
		
		// nodes are on different sides
		if(n1OnLeft != n2OnLeft) 
			return root;
		
		// nodes are on the same side
		// if n1 is on the left, n2 must also be on 
		// the left; so, next node to search for would be 
		// the left child of root.
		Node nextNode = n1OnLeft ? root.left : root.right;
		
		return getFirstCommonAncestorHelper(nextNode, n1, n2);
	}

	public boolean isInTree(Node root, Node subject) {
		if(root == null)
			return false;
		
		if(subject == root)
			return true;
		
		return (isInTree(root.left, subject) || isInTree(root.right, subject));
	}
	
	public static void main(String[] args) {
		TreeGraph4_7 Ancestors = new TreeGraph4_7();
		
		// get a binary search tree
		TreeGraph4_3 BTree = new TreeGraph4_3();
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = BTree.getTree(arr, 0, arr.length-1);
		
		Node p = root.left.left;
		Node q = root.left.right;
		
		Node ancestor = Ancestors.getFirstCommonAncestor(root, p, q);
		System.out.println("First common ancestor: " + ancestor);
	}
}
