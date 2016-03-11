package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter 
 * combinations that the number could represent. 
 * A mapping of digit to letters (just like on the 
 * telephone buttons) is given below.
 * @author Debosmit
 *
 */
public class Letter_Combinations_of_a_Phone_Number {

	private String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
    	
    	if(digits == null || digits.length() == 0)
    		return new ArrayList<String>();
    	
        List<String> choices = new ArrayList<String>();
        for(int i = 0 ; i < digits.length() ; i++)
            choices.add(letters[ digits.charAt(i) - '0' ]);
        
        List<String> combination = new ArrayList<String>();
        // add character for first digit
        for(int c = 0 ; c < choices.get(0).length() ; c++) 
        	combination.add(String.valueOf(choices.get(0).charAt(c)));
        
        for(int i = 1 ; i < choices.size() ; i++) {
        	// say sbs looks like ["a", "b", "c"]
        	// current string to be considered is "pqrs"
        	// 'a' has 4 potential partners, same for 'b', 'c', 'd'
        	List<String> newCombination = new ArrayList<String>();
        	
        	for(int st = 0 ; st < combination.size() ; st++) {
        		for(int charAdd = 0 ; charAdd < choices.get(i).length() ; charAdd++) {
        			String newString = combination.get(st) + choices.get(i).charAt(charAdd);
        			newCombination.add(newString);
        		}
        	}
        	combination = newCombination;
        }
        
        return combination;
    }
    
    public static void main(String[] args) {
    	String in = "23";
    	Letter_Combinations_of_a_Phone_Number Converter = 
    					new Letter_Combinations_of_a_Phone_Number();
    	System.out.println(Converter.letterCombinations(in));
    }
}
