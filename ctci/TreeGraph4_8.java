package ctci;

import dataStructures.BinaryTree.Node;

/**
 * Two binary trees, T1 and T2.
 * Check if T2 is a subtree of T1.
 * @author Debosmit
 *
 */
public class TreeGraph4_8 {
	
	public boolean containsTree(Node t1, Node t2) {
		// empty tree is a subtree
		if(t2 == null)
			return true;
		
		return containsTreeHelper(t1, t2);
	}

	private boolean containsTreeHelper(Node t1, Node t2) {
		// big tree t1 is empty
		if(t1 == null)
			return false;
		
		// need to parse t2 to check
		// if it a subtree
		if(t1.value == t2.value)
			if(matchTree(t1, t2))
				return true;
		
		return containsTreeHelper(t1.left, t2) || containsTreeHelper(t1.right, t2);
	}

	private boolean matchTree(Node t1, Node t2) {
		if(t1 == null && t2 == null)
			return true;
		
		if(t1 == null || t2 == null)
			return false;
		
		if(t1.value != t2.value)
			return false;
		
		return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
	}

}
