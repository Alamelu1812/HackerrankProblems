public class UniqueCharacters {
	boolean isUnique(String s) {
		int[] counts = new int[128]; //Assumption that the character set is ASCII
		
		for(Character c:s.toCharArray()) {
			//If character is previously seen, return false. Else, increment counts array
			if(counts[c-'a']!=0)
				return false;
			counts[c-'a']++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		UniqueCharacters object = new UniqueCharacters();
		
		//TestCase1
		String input1 = "abcdef";
		System.out.println(object.isUnique(input1));
		
		//TestCase2
		String input2 = "abcdefa";
		System.out.println(object.isUnique(input2));
	}
}
