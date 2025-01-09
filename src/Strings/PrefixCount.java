package Strings;


//2185. Counting Words With a Given Prefix
public class PrefixCount {
    public static void main(String[] args) {
        String words[] = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }

    static public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) count++;
        }
        return count;
    }
}
