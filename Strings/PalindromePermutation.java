/*
 * Given a string, determine if a permutation of the string could form a palindrome.
 */

import java.util.*;
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		
		//Create a map with frequency counts
        HashMap<Character,Integer> freqMap = new HashMap<Character,Integer>();
        for(char c:s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)){
                freqMap.put(c,freqMap.getOrDefault(c,0)+1);
            }
        }
        
        //The maximum number of characters with odd count can be one
        //If above rule is violated, return false
        boolean foundOdd = false;
        for(Character key:freqMap.keySet()) {
        	if(freqMap.get(key)%2!=0) {
        		if(foundOdd)
        			return false;
        		foundOdd = true;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		PalindromePermutation object = new PalindromePermutation();
		
		//TestCase1
		String input1 = "aab";
		System.out.println("Is "+input1+" a palindrome permutation?"+object.canPermutePalindrome(input1));
		
		//TestCase2
		String input2 ="code";
		System.out.println("Is "+input2+" a palindrome permutation?"+object.canPermutePalindrome(input2));
	}

}
