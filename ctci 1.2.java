public class stringPermutation {
	
	// sort for O(n log n) time
	// boolean array again O (n)
	public static boolean isPermutation( String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		int [] cSet1 = new int [128]; // assuming ASCII char set
		char[] sOne = s1.toCharArray();
		for (char c: sOne) {
			cSet1[c] += 1;
		}

		int [] cSet2 = new int [128];
		char[] sTwo = s2.toCharArray();
		for (char c: sTwo) {
			cSet2[c] += 1;
		}
		
		for (int i = 0; i < 128 ; ++i) {
			if (cSet1[i] != cSet2[i]) return false;
		}

		return true;
	}

	public static void main (String [] args) {
        String z = "hello";
        String a = "leloh" ;

        System.out.println(isPermutation(z, a));

    }

}