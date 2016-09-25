// Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring

public class stringRotation {

	public static boolean isRotation (String s1, String s2) {
		if (s1.length() != s2.length || s1.length == 0) return false;
		
		String s3 = s2 + s2;
		return isSubstring(s1, s3) 
	}
}