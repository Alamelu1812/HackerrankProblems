//The program uses String Builder instead of String
//Time complexity of modifying a String is O(n^2)
//Time complexity of modifying a StringBuilder is O(n)
public class StringCompression {
	
	public String compressString(String s) {
		char[] charArray = s.toCharArray();
		int count = 0;
		StringBuilder compressedString = new StringBuilder();
		
		for(int i=0;i<charArray.length;i++) {
			count++;
			
			if(i+1>=charArray.length || charArray[i]!=charArray[i+1]) {
				compressedString.append(charArray[i]);//append character
				compressedString.append(count);//append consecutive count for the character
				
				count = 0;//Resetting count for next unique character
			}
		}
		
		return compressedString.length()<s.length()? compressedString.toString():s;
		
	}
	
	public static void main(String[] args) {
		StringCompression object = new StringCompression();
		
		//TestCase
		String input = "aabbbccccccccaaadddd";
		String output = object.compressString(input);
		System.out.println("Input "+input);
		System.out.println("Output "+output);
	}

}
