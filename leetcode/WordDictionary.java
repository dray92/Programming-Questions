package leetcode;

import java.util.HashMap;
import java.util.Set;

public class WordDictionary {
	
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
	
	public WordDictionary() {
		this.root = new TrieNode();
	}

    // Adds a word into the data structure.
    public void addWord(String word) {
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i = 0 ; i < word.length() ; i++) {
        	char c = word.charAt(i);
        	TrieNode t = null;
        	if(children.containsKey(c)) {
        		t = children.get(c);
        	} else {
        		t = new TrieNode(c);
        		children.put(c, t);
        	}
        	children = t.children;
        	
        	if(i == word.length()-1)
        		t.isLeaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	TrieNode t = search(root, word);
    	
    	if(t != null && t.isLeaf)
    		return true;
    	return false;
        
    }
	
	private TrieNode search(TrieNode root, String word) {
		if(root.isLeaf && word.length() == 0)
			return root;
		
		if(root == null || word.length() == 0) 
			return null;
		
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		
		char c = word.charAt(0);
		Set<Character> keys = children.keySet();
		if(c == '.') {
			for(char key: keys) {
				TrieNode myNode = search(children.get(key), word.substring(1));
				if(myNode != null) {
					t = myNode;
					break;
				}
			}
		} else {
			if(keys.contains(c)) 
				t = search(children.get(c), word.substring(1));
			else 
				t = null;
		}
		return t;
	}
	
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("doggy");
		System.out.println("Does d.g exists? " + wordDictionary.search("d.g.y"));
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");