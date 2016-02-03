package leetcode;

import java.util.HashMap;

public class Trie {
	
	private TrieNode root;
	
	public class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;
		
		public TrieNode() {}
		
		public TrieNode(char c) {
			this.c = c;
		}
	}
	
	public Trie() {
		root = new TrieNode();
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	// Inserts a word into the trie
    public void insert(String word) {
    	HashMap<Character, TrieNode> children = root.children;
    	
    	for(int i = 0 ; i < word.length() ; i++) {
    		char c = word.charAt(i);

    		TrieNode t;
    		if(children.containsKey(c))
                t = children.get(c);
    		else {
				t = new TrieNode(c);
				children.put(c, t);
    		}
    		children = t.children;
    		
    		//set to be leaf node, if last character
            if(i == word.length()-1)
                t.isLeaf = true;
    	}
    }
    
    // Returns if the word is in the trie
    public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isLeaf) 
            return true;
        else
            return false;
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        return true;
    }
    
    private TrieNode searchNode(String prefix) {
    	HashMap<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        
        for(int i = 0 ; i < prefix.length() ; i++) {
        	char c = prefix.charAt(i);
        	if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else
                return null;   
        }
        return t;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	String st = "somestring";
    	trie.insert(st);
    	System.out.println("Does + \'" + st + "\' exists? " + trie.search(st));
    }
}
