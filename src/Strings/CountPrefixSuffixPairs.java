package Strings;


//3042. Count Prefix and Suffix Pairs I
public class CountPrefixSuffixPairs {
    public static void main(String[] args) {
        String[] words = {"a", "aba", "ababa", "aa"};
        System.out.println(countPrefixSuffixPairs(words));
    }

    static public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
