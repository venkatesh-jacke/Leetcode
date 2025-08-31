package TwoPointer;

//1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence

public class IsPrefixOfWord {
    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    static public int isPrefixOfWord(String sentence, String searchWord) {
        int charPos = 1;
        int i = 0;
        int n = sentence.length();
        while (i < n) {
            //Skip spaces and move to the next word
            while (i < n && sentence.charAt(i) == ' ') {
                charPos++;
                i++;
            }
            int j = 0;
            //Compare current word in sentence with searchWord
            while (i < n && j < searchWord.length() && searchWord.charAt(j) == sentence.charAt(i)) {
                i++;
                j++;
            }
            //If entire searchWord is matched, return word index
            if (j == searchWord.length()) return charPos;
            // Skip rest of the current word if prefix not matched
            while (i < n && sentence.charAt(i) != ' ') i++;
        }
        return -1;
    }
}
