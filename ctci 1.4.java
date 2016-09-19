public class PalindromePermutation {
    public static boolean isPermutationOfPalindrome (String s) {
        int bitVector = 0;
        s = s.toLowerCase();
        s = s.replaceAll("\\s+,", "");
        char [] sChar = s.toCharArray();
        for (char c: sChar) {

            int letter = c - 'a';
            bitVector ^= 1 << letter;
        }

        int mask = bitVector - 1;

        int bitSet = 0;

        // Check if only one bit is set, but don't check the last bit. Java's integers have the signed bit set.
        for (int i = 0; i < 25; ++i) {
            if (((bitVector >> i) & 1) != 0) {
                bitSet++;
            }
        }

        if (bitSet > 1) return false;
        return true;
    }

    public static void main (String [] args) {
        String z = "Tact Coa";
        String x = "tactcoapapa";
        System.out.println(isPermutationOfPalindrome(z));
        System.out.println(isPermutationOfPalindrome(x));

    }
}