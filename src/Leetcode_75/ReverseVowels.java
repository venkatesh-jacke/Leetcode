package Leetcode_75;


//345. Reverse Vowels of a String
public class ReverseVowels {
    public static void main(String[] args) {

    }

    static public String reverseVowels(String s) {
        int len = s.length();
        char[] ca = s.toCharArray();
        int i = 0, j = len - 1;
        while (i <= j) {
            if (isVowel(ca[i]) && isVowel(ca[j])) {
                char temp = ca[i];
                ca[i] = ca[j];
                ca[j] = temp;
                i++;
                j--;
            } else if (isVowel(ca[i]) && !isVowel(ca[j]))
                j--;
            else
                i++;
        }
        return new String(ca);
    }

    static public boolean isVowel(char c) {
        return ((c > 64 && c < 91) || (c > 96 && c < 123)) && ("AEIOUaeiou".indexOf(c) != -1);
    }
}
