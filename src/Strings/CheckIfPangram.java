package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


//1832. Check if the Sentence Is Pangram
public class CheckIfPangram {
    public static void main(String[] args) {
        // String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence = "leetcode";
        System.out.println(checkIfPangram(sentence));
    }


    //Tc is O(n) Sc O(1)
    static public boolean checkIfPangram(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int index = cur - 'a';
            if (arr[index] != ' ') {
                arr[index] = cur - 'a';
            }

        }
        for (int i : arr) {
            if (i == -1) return false;
        }
        return true;
    }
}
