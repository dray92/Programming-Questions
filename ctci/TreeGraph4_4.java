package ctci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import dataStructures.BinaryTree.Node;

/**
 * Given a binary tree, design an algorithm 
 * which creates a linked list of all the nodes
 * at each depth.
 * @author Debosmit
 *
 */
public class TreeGraph4_4 {

	public ArrayList<LinkedList<Node>> getLinkedLists(Node root) {
		if(root == null)
			return null;
		
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		Queue<Node>	queue = new LinkedList<Node>();
		queue.add(root);
		int numAtLevel = 1;		// number of nodes at current level
		int numAtNextLevel = 0; // number of nodes at next level
		LinkedList<Node> curList = new LinkedList<Node>(); // nodes at current level
		while(!queue.isEmpty()) {
			Node curNode = queue.remove();
			curList.add(curNode);
			numAtLevel--;
			if(curNode.left != null) {
				queue.add(curNode.left);
				numAtNextLevel++;
			}
			if(curNode.right != null) {
				queue.add(curNode.right);
				numAtNextLevel++;
			}
			if(numAtLevel == 0) {
				lists.add(curList);
				curList = new LinkedList<Node>();
				numAtLevel = numAtNextLevel;
				numAtNextLevel = 0;
			}
		}
		return lists;
	}
	
	public static void main(String[] args) {
		TreeGraph4_4 BFS = new TreeGraph4_4();
		
		// get a binary tree
		TreeGraph4_3 BTree = new TreeGraph4_3();
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = BTree.getTree(arr, 0, arr.length-1);
		
		ArrayList<LinkedList<Node>> lists = BFS.getLinkedLists(root);
		for(LinkedList<Node> list: lists) 
			System.out.println(list);
		
	}
}
