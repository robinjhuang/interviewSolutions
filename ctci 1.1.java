// Implement an algorithm to determine if a string has all unique characters. What if you can’t use additional data structures?

public class stringsWithUniqueChars {
	
	// assuming capital letters and lower case letters are considered different characters

	// O(n log n) time complexity
	public static boolean hasUniqueChars(String s) {
		s = s.replaceAll("\\s+", "");
		char [] sChar = s.toCharArray();
		Arrays.sort(sChar);

		for (int i = 0; i < s.length() - 1; ++i) {
			if (sChar[i] == sChar[i + 1]) return false;
		}

		return true;
	}
	
	// Use an array of booleans to represent character sets
	// Assuming ASCII Characters of 256 characters
	public static boolean hasUniqueChars2(String s) {
		boolean [] asciiCharSet = new boolean[256 + 1];
		s = s.replaceAll(“\\s+”, “”);
		for (int i = 0 ; i < s.length(); ++i) {
			if (asciiCharSet[((int) s.charAt(i))] == false) {
				asciiCharSet[((int) s.charAt(i))] = true;
			}
	
			else 
				return false;
		} 
		return true;
	}

	public static void main (String [] args) {

		String a = "I am a non unique string of words" ;
		String u = "zxw da ht";

		System.out.println(hasUniqueChars(a));
		System.out.println(hasUniqueChars(u));

	}
}