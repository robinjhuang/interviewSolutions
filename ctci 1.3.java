public static String urlifyString (String s , int size) {
        char [] sChar = s.toCharArray();

        int insertPointer = s.length() - 1;
        int findNonSpaceChar = s.length() - 1;

        // find last non space character
        while (findNonSpaceChar >= 0 ) {
            if (sChar[findNonSpaceChar] == ' ') --findNonSpaceChar;
            else break;
        }

        // find end of first word, we'll stop here
        int lastLetterOfFirstWord = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (sChar[i] != ' ') lastLetterOfFirstWord++;
            else break;
        }

        // if we find a space, we’ll insert a %20
        // if we find a character, we insert it in the right place
        while (insertPointer > lastLetterOfFirstWord ) {
            if (sChar[findNonSpaceChar] == ' ') {
                --findNonSpaceChar;
                sChar[insertPointer--] = '0';
                sChar[insertPointer--] = '2';
                sChar[insertPointer--] = '%';
            }

            else {
                sChar[insertPointer--] = sChar[findNonSpaceChar];
                sChar[findNonSpaceChar--] = ' ';
            }
        }

        return new String(sChar);
    }


    public static void main (String [] args) {
        String z = "Mr John Smith    ";

        System.out.println("dwad ");
        System.out.println(urlifyString(z, 13));

    }