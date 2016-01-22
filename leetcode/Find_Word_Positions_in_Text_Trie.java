package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/*
 * Given a text file and a word, find the positions 
 * that the word occurs in the file. We’ll be asked to 
 * find the positions of many words in the same file.
 */

public class Find_Word_Positions_in_Text_Trie {

	Trie trie;
	
	private class TrieNodeSet {
		char c;
		HashMap<Character, TrieNodeSet> children = new HashMap<Character, TrieNodeSet>();
		boolean isWord;
		Set<Integer> positions = new HashSet<Integer>();
		
		TrieNodeSet() {}
		
		TrieNodeSet(char c) {
			this.c = c;
		}
		
		char getChar() {
			return this.c;
		}
	}
	
	private class Trie {
		TrieNodeSet root;
		
		Trie() {
			root = new TrieNodeSet();
		}
		
		boolean insert(String word, int position) {
			try {
				HashMap<Character, TrieNodeSet> curChildren = root.children;
				for(int i = 0 ; i < word.length() ; i++) {
					char ch = word.charAt(i);
					TrieNodeSet t;
					if(curChildren.keySet().contains(ch))
						t = curChildren.get(ch);
					else {
						t = new TrieNodeSet(ch);
						curChildren.put(ch, t);
					}
					curChildren = t.children;
					
					// when to add word tag and update/create 
					// set of positions
					if(i == word.length() - 1) {
						t.isWord = true;
						t.positions.add(position);
					}
				}
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		
		boolean contains(String word) {
			TrieNodeSet cur = root;
			for(int i = 0 ; i < word.length();  i++) {
				char ch = word.charAt(i);
				if(!cur.children.keySet().contains(ch))
					return false;
				cur = cur.children.get(ch);
			}
			return cur.isWord;
		}
		
		Set<Integer> getItem(String word) {
			if(!contains(word))
				return new HashSet<Integer>();
			TrieNodeSet cur = root;
			for(int i = 0 ; i < word.length();  i++) 
				cur = cur.children.get(word.charAt(i));
			
			return cur.positions;
		}
	}
	
	public Find_Word_Positions_in_Text_Trie() {
		trie = new Trie();
	}
	
	public String[] getWords(String text) {
		// converting to lower case
		text = text.toLowerCase();
		
		// converting non alpha-numeric to spaces
		text = text.replaceAll("[^a-z0-9]", " ");
		
		// split based on spaces
		return text.split(" ");
	}
	
	public void createIndex(String[] words) {
		int count = 0;
		for(String word: words) 
			trie.insert(word, count++);
	}
	
	public Set<Integer> queryIndex(String word) {
		if(trie.contains(word)) 
			return trie.getItem(word);
		return null;
	}
	
	public static void main(String[] args) {
		Find_Word_Positions_in_Text_Trie it = new Find_Word_Positions_in_Text_Trie();
		
		String text = "a_b 1`3a a";
		String[] words = it.getWords(text);
		System.out.println("Words: " + Arrays.toString(words));
		
		it.createIndex(words);
		String word = "3a";
		System.out.println("Positions for " + word + ": " + Arrays.toString(it.queryIndex(word).toArray()) + "\n\n");
		
		
		text = "a_b 1`3a a";
		words = it.getWords(text);
		System.out.println("Words: " + Arrays.toString(words));
		
		it.createIndex(words);
		word = "3a";
		System.out.println("Positions for " + word + ": " + Arrays.toString(it.queryIndex(word).toArray()));
	}
}
