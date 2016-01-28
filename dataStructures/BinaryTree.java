package dataStructures;

public class BinaryTree {
	
	// In-order traversal
	public static void traverse(Node root) {
		if(root != null) {
			traverse(root.left);
			System.out.print(root.value + " ");
			traverse(root.right);
		}
	}
	
	public static int getHeight(Node root) {
		if(root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static int getDepth(Node root, int val, int level) {
		if(root == null)
			return 0;
		
		if(root.value == val) {
			return level;
		}
		
		// searching left subtree
		int retLevel = getDepth(root.left, val, level++);
		if(retLevel != 0) 
			return retLevel;
		
		retLevel = getDepth(root.right, val, level++);
		return retLevel;
	}
	
	public static boolean isPerfect(Node root) {
		if(root == null)
			return true;
		
		if( (root.left != null && root.right == null) || (root.left == null && root.right != null)) 
			return false;
		
		return true && isPerfect(root.left) && isPerfect(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(5, new Node(3), new Node(6));
		// testing in-order traversal
		traverse(root);
		System.out.println("\n");
		
		// testing height of tree
		root = new Node(6, new Node(4, new Node(3), new Node(5)), new Node(10, null, new Node(12, new Node(11), null)));
		System.out.println("Height of tree: " + getHeight(root));
		System.out.println();
		
		// testing depth for Node 5
		System.out.println("Depth of node 5: " + getDepth(null, 5, 1));
		System.out.println();
		
		//testing if tree is perfect
		System.out.println("Is tree perfect? " + isPerfect(root));
		System.out.println();
				
		// testing BST
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(bst.getRoot(), new Node(5));
		bst.insert(bst.getRoot(), new Node(4));
		bst.insert(bst.getRoot(), new Node(6));
		bst.insert(bst.getRoot(), new Node(1));
		bst.insert(bst.getRoot(), new Node(2));
		bst.insert(bst.getRoot(), new Node(3));
		bst.insert(bst.getRoot(), new Node(0));
		root = bst.getRoot();
		System.out.print("BST: ");
		traverse(root);
		System.out.println("\n");
		
		System.out.print("After deletion of 1, BST: ");
		bst.delete(1);
		traverse(root);
		System.out.println("\n");
		
		Node search = bst.getNode(5);
		System.out.println("Node 5 has address " + (search == null ? "NULL" : search) 
				 + " and value: " + (search == null ? "NULL" : search.value));
		
		search = bst.getNode(15);
		System.out.println("Node 15 has address " + (search == null ? "NULL" : search) 
				 + " and value: " + (search == null ? "NULL" : search.value) + "\n");
		
		AVLTree avl = new AVLTree();
		avl.insert(10);
		avl.insert(5);
		avl.insert(15);
		avl.insert(2);
		avl.insert(4);
		System.out.print("AVL: ");
		traverse(avl.getRoot());
		System.out.println("\nRoot of AVL Tree: " + avl.getRoot().value);
		System.out.println("\n");
		avl.delete(15);
		System.out.print("AVL after deletion of 15: ");
		traverse(avl.getRoot());
		System.out.println("\nRoot of AVL Tree: " + avl.getRoot().value);
		System.out.println("\n");
		
		avl = new AVLTree();
		avl.insert(6);
		avl.insert(3);
		avl.insert(7);
		avl.insert(1);
		System.out.print("AVL: ");
		traverse(avl.getRoot());
		System.out.println("\nRoot of AVL Tree: " + avl.getRoot().value);
		System.out.println("\n");
		avl.delete(7);
		System.out.print("AVL after deletion of 7: ");
		traverse(avl.getRoot());
		System.out.println("\nRoot of AVL Tree: " + avl.getRoot().value);
		System.out.println("\n");
				
	}
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public int height;
		public int size;

		public Node(int value) {
			this(value, null, null);
		}
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.height = 1;
		}
		
		public String toString() {
			return "" + this.value;
		}
	}
}
