package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break_II {
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s== null || s.length() == 0)
        	return new ArrayList<String>();
        
        List<List<String>> possibilities = new ArrayList<List<String>>(s.length() + 1);
        
        for(int i = 0 ; i < s.length() + 1 ; i++)
        	possibilities.add(null);
        
        possibilities.set(0, new ArrayList<String>());
        
        for(int i=0; i < s.length(); i++){
            if( possibilities.get(i) == null ) 
                continue; 
            
            for(String word: wordDict) {
            	int len = word.length();
            	int end = len + i;
            	
            	// if word can't fit
            	if(end > s.length()) 
                    continue;
            	
            	if(s.substring(i,end).equals(word)){
            		// add list if not present
                    if(possibilities.get(end) == null)
                    	possibilities.set(end, new ArrayList<String>());
                    
                    possibilities.get(end).add(word);
                }
            }
        }
        
        List<String> result = new ArrayList<String>();
        if(possibilities.get(s.length()) == null) 
            return result; 
        
        List<String> temp = new ArrayList<String>();
        dfs(possibilities, s.length(), result, temp);
        
        return result;
    }
	
	private void dfs(List<List<String>> possibilities, int end,
			List<String> result, List<String> temp) {
		
		// reached end, create sentence out of temp and add
		if(end <= 0) {
			result.add(String.join(" ", temp));
	        return;
	    }
		
		for(String word: possibilities.get(end)) {
			// add word to the top of the list
			temp.add(0, word);
			
			// recurse
			dfs(possibilities, end - word.length(), result, temp);
			
			// remove word from top of list
			temp.remove(0);
		}
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		
		String[] dict = new String[]{"cat", "cats", "and", "sand", "dog"};
		for(String word: dict)
			wordDict.add(word);
		
		List<String> result = new Word_Break_II().wordBreak(s, wordDict);
		System.out.println(result);
	}
	
}
