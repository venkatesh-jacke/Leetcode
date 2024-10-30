package Strings;

import java.util.HashSet;


//1593. Split a String Into the Max Number of Unique Substrings
public class MaxUniqueSplit {
    public static void main(String[] args) {
        String s = "aba";
        String s1 = "ababccc";
        System.out.println(maxUniqueSplit(s1));
    }

    static public int maxUniqueSplit(String s) {
        int i = 0, res = 0;
        HashSet<String> set = new HashSet<>();
        while (i < s.length()) {
            String c = s.substring(i, i + 1);
            if (!set.contains(c)) {
                res++;
                set.add(c);
                i += 1;
            } else {
                while ((i + 2) < s.length() && set.contains(s.substring(i, i + 2))) {
                    i += 2;
                }
                if((i+2)<s.length()){
                    set.add(s.substring(i, i + 2));
                    res++;
                    i+=2;
                }
                else{
                    set.add(s.substring(i));
                    res++;
                    i++;
                }
            }
        }
        return res;
    }

}
