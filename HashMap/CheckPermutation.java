
public class CheckPermutation {
	boolean isPermutation(String s,String t) {
		int[] counts = new int[26]; //Assumption that the character set is lower case set of letters
		
		//Increment counts of character for string s
		for(Character c:s.toCharArray()) 
			counts[c-'a']++;
		
		//Decrement counts of character for string t
		for(Character c:t.toCharArray()) 
			counts[c-'a']--;
		
		//If the counts array become zero entirely, return true
		for(int i=0;i<counts.length;i++) {
			if(counts[i]!=0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckPermutation object = new CheckPermutation();
		
		//TestCase1
		String input1 = "abcdef";
		String input2 = "fedabc";
		System.out.println(object.isPermutation(input1,input2));
		
		//TestCase2
		input1 = "abcdefa";
		input2 = "aabcdefa";
		System.out.println(object.isPermutation(input1,input2));
	}

}
