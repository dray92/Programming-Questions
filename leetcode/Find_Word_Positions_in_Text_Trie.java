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
	}
	
	private class Trie {
		TrieNodeSet root;
		
		Trie() {
			root = new TrieNodeSet();
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
			TrieNodeSet cur = root;
			for(int i = 0 ; i < word.length();  i++) {
				char ch = word.charAt(i);
				if(!cur.children.keySet().contains(ch))
					cur.children.put(ch, new TrieNodeSet(ch));
				cur = cur.children.get(ch);
			}
			cur.isWord = true;
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
		for(String word: words) 
			trie.getItem(word);
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
		String word = "a";
		System.out.println("Words: " + Arrays.toString(it.queryIndex(word).toArray()));
		
		
	}
}
