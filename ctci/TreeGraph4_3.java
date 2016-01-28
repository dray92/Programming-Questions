package ctci;

import dataStructures.BinaryTree.Node;

/**
 * Given a sorted array with unique integers,
 * create a binary tree of minimal height.
 * 
 * @author Debosmit
 *
 */
public class TreeGraph4_3 {

	public Node getTree(int[] values, int start, int end) {
		int length = start + end;
		int mid = length/2;
		
		if(end < start)
			return null;
		
		Node root = new Node(values[mid]);
		root.left = getTree(values, start, mid-1);
		root.right = getTree(values, mid+1, end);
		return root;
	}
	
	// In-order traversal
	private void traverse(Node root) {
		if(root != null) {
			traverse(root.left);
			System.out.print(root.value + " ");
			traverse(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeGraph4_3 BTree = new TreeGraph4_3();
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = BTree.getTree(arr, 0, arr.length-1);
		BTree.traverse(root);
	}
}
