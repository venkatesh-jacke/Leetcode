package Leetcode_75;


//345. Reverse Vowels of a String
public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    static public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] ca = s.toCharArray();
        while (i < j) {
            while (i < j && !isVowel(ca[i])) {
                i++;
            }
            while (i < j && !isVowel(ca[j])) {
                j--;
            }
            char temp = ca[i];
            ca[i] = ca[j];
            ca[j] = temp;
            i++;
            j--;

        }
        return new String(ca);
    }

    static public boolean isVowel(char c) {
        return ((c > 64 && c < 91) || (c > 96 && c < 123)) && ("AEIOUaeiou".indexOf(c) != -1);
    }
}
