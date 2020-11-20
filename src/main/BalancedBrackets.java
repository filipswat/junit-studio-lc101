package main;
import java.util.ArrayList;

public class BalancedBrackets {
    /**
     * The function BalancedBrackets should return true if and only if
     * the input string has a set of "balanced" brackets.
     *
     * That is, whether it consists entirely of pairs of opening/closing
     * brackets (in that order), none of which mis-nest. We consider a bracket
     * to be square-brackets: [ or ].
     *
     * The string may contain non-bracket characters as well.
     *
     * These strings have balanced brackets:
     *  "[LaunchCode]", "Launch[Code]", "[]LaunchCode", "", "[]"
     *
     * While these do not:
     *   "[LaunchCode", "Launch]Code[", "[", "]["
     *
     * @param str - to be validated
     * @return true if balanced, false otherwise
     */
    public static boolean hasBalancedBrackets(String str) {
        int currPos = 0;
        int lastPos = 0;
        String tempString;
        ArrayList<String> strSegs = new ArrayList<>();
        ArrayList<Boolean> quoteTrack = new ArrayList<>();
        char typeOfQuote;
        int i;
        int brackets = 0;

        //convert str to character array
        char[] charArray = str.toCharArray();
        //for i = 0 to length of character array
        while (currPos < charArray.length){
            //if character is single or double quote
            if ((charArray[currPos] == '\'') || (charArray[currPos] == '\"')){
                //if lastPos != currPos (indicating something exists before current position)
                if (lastPos != currPos) {
                    //place characters from lastPos to previous character in strSegs
                    //add false to quoteTrack
                    tempString = new String(charArray, lastPos, currPos - lastPos);
                    strSegs.add(tempString);
                    quoteTrack.add(false);
                    //update lastPos (position of open quote)
                    lastPos = currPos;
                }
                //update typeOfQuote to single or double quote
                typeOfQuote = charArray[currPos];
                //do
                    //increment currentPos
                    //while current character != typeOfQuote
                do {
                    currPos = currPos + 1;
                } while (charArray[currPos] != typeOfQuote);
                //place characters from lastPos to currentPos in strSegs
                //add true to quoteTrack
                tempString = new String(charArray, lastPos, currPos - lastPos + 1);
                strSegs.add(tempString);
                quoteTrack.add(true);
                //if not at end of array
                    //lastPos = next character
                if (currPos != charArray.length - 1) {
                    lastPos = currPos + 1;
                } else {
                    lastPos = currPos;
                }
            }
            //increment currPos
            currPos++;
        }

        //make sure that entire string is added to character array
        if (currPos != lastPos){
            tempString = new String(charArray, lastPos, currPos - lastPos);
            strSegs.add(tempString);
            quoteTrack.add(false);
        }

        for (i = 0; i < strSegs.size(); i++) {
            //for i = 0 to size of strSegs
                //if !quoteTrack[i]
                //run bracket check
            if (!quoteTrack.get(i)) {
                //bracketCheck
                for (char ch : strSegs.get(i).toCharArray()) {
                    if (ch == '[') {
                        brackets++;
                    } else if (ch == ']') {
                        brackets--;
                        if (brackets < 0) {
                            return false;
                        }
                    }
                }
                //return brackets == 0;
            }
        }

        return brackets == 0;
    }
}
