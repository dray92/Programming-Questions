package ctci;

import dataStructures.BinaryTree.Node;

/**
 * Given a binary tree, find all 
 * paths that sum to a given value.
 * Path won't necessarily start or 
 * end at root or leaf.
 * @author Debosmit
 *
 */
public class TreeGraph4_9 {

	public int[] getPathToSum(Node root, int sum) {
		int height = getHeight(root);
		
		// maximum length of path cannot be 
		// greater than the height of the tree
		int[] path = new int[height];
		
		getPathToSum(root, path, sum, 0);
		return path;
	}
	
	private void getPathToSum(Node node, int[] path, int sum, int level) {
		if(node == null)
			return;
		
		// insert node data at the
		// current position in the array
		path[level] = node.value;
		
		int t = 0;
		for(int i = level; i >= 0 ; i--) {
			t += path[i];
			if(t == sum)
				print(path, i, level);
		}
		
		// search children nodes
		getPathToSum(node.left, path, sum, level+1);
		getPathToSum(node.right, path, sum, level+1);
		
		// remove current node from the path
		path[level] = Integer.MIN_VALUE;
		
	}

	private void print(int[] path, int startIndex, int endIndex) {
		for(int i = startIndex ; i <= endIndex ; i++)
			System.out.print(path[i] + " ");
		
		System.out.println();
	}

	private int getHeight(Node root) {
		if(root == null)
			return 0;
		
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static void main(String[] args) {
		Node root = new Node(6, new Node(4, new Node(3), new Node(5)), 
				new Node(10, null, new Node(12, new Node(11), null)));
		
		TreeGraph4_9 Sum = new TreeGraph4_9();
		
		Sum.getPathToSum(root, 9);
	}
}
