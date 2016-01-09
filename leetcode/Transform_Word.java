package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

/*
 * Given a source word, target word and an English dictionary, 
 * transform the source word to target by changing/adding/removing 1 character 
 * at a time, while all intermediate words being valid English words. 
 * Return the transformation chain which has the smallest number of intermediate words.
 */
public class Transform_Word {
	
	private final String DICTIONARY_SOURCE = "http://web.stanford.edu/class/cs106l/assignments/dictionary.txt";
	private HashMap<String, List<String>> map;
	
	private HashMap<String, List<String>> preProcess(String[] dictionary) {
		if(this.map != null)
			return this.map;
		
		this.map = new HashMap<String, List<String>>();
		
		StringBuilder letters = new StringBuilder();
		char ch = 'a';
		while(ch <= 122) 
			letters.append(ch++);
		
		for(String word: dictionary) {
			for(int i = 0 ; i < word.length() ; i++) {
				// CASE 1: remove one char from the word
				String remove = word.substring(0,i) + word.substring(i+1);
				
				if(map.containsKey(word)) 
					map.get(word).add(remove);
				
				// CASE 2: change one character in the word
				for(int chars = 0 ; chars < letters.length() ; chars++) {
					String changedWord = word.substring(0,i) + letters.charAt(chars) + word.substring(i+1);
					
					// ASSUMPTION: dictionary contains words in alphabetical order
					// checking if word exists in dictionary
					// ensuring that character inserted doesn't make it the same word
					if(Arrays.binarySearch(dictionary, changedWord) >= 0 && !word.equals(changedWord)) {
						List<String> list = map.get(word);
						if(list != null)
							map.get(word).add(changedWord);
						else {
							List<String> newList = new ArrayList<String>();
							newList.add(changedWord);
							map.put(word, newList);
						}
					}
				}
			}
			// CASE 3: add one char to the word
			StringBuilder wordsb = new StringBuilder(word);
			for(int i = 0 ; i < wordsb.length()+1 ; i++) {
				for(int chars = 0 ; chars < letters.length() ; chars++) {
					// inserting character at index i
					wordsb.insert(i, letters.charAt(chars));
					
					// converting the string builder to string
					String changedWord = wordsb.toString();
					
					// ASSUMPTION: dictionary contains words in alphabetical order
					// checking if word exists in dictionary
					// ensuring that character inserted doesn't make it the same word
					if(Arrays.binarySearch(dictionary, changedWord) >= 0 && !word.equals(changedWord)) {
						List<String> list = map.get(word);
						if(list != null)
							map.get(word).add(changedWord);
						else {
							List<String> newList = new ArrayList<String>();
							newList.add(changedWord);
							map.put(word, newList);
						}
					}
					
					// remove inserted character from string builder for insertion 
					// of next character at the same index
					wordsb.replace(i, i+1, "");
				}
			}
		}
		
		return map;
	}
	
	public ArrayList<String> transformWord(HashMap<String, List<String>> graph, String start, String target) {
		Deque<ArrayList<String>> paths = new LinkedList<ArrayList<String>>();
		Set<String> extended = new HashSet<String>();
		
		ArrayList<String> first = new ArrayList<String>();
		first.add(start);
		paths.push(first);
		
		while(paths.size() != 0) {
			ArrayList<String> currentPath = paths.pollFirst();
			String currentWord = currentPath.get(currentPath.size()-1);
			if(target.equals(currentWord)) 
				return currentPath;
			else if(extended.contains(currentWord)) 
				continue;
			
			extended.add(currentWord);
			
			List<String> transforms = graph.get(currentWord);
			for(String word: transforms) 
				if(!currentPath.contains(word)) {
					currentPath.add(word);
					paths.add(currentPath);
				}
				
			
		}
		
		return null;
	}
	
	// source: http://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code
	private static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine + "\n");

        in.close();

        return response.toString();
    }
	
	public static void main(String[] args) throws Exception {
//		String[] dictionary = getText(DICTIONARY_SOURCE).split("\n");
//		String[] dictionary = {"cat", "cathode", "cats"};
		String[] dictionary = {"cat", "bat", "bet", "bed", "at", "ad", "ed"};
		
		Transform_Word transformer = new Transform_Word();
		HashMap<String, List<String>> graph = transformer.preProcess(dictionary);
//		ArrayList<String> words = transformer.transformWord(graph, "cat", "cats");
		ArrayList<String> words = transformer.transformWord(graph, "cat", "bed");
		for(String word: words)
			System.out.print(word + " - > ");
		System.out.println();
	}
}
