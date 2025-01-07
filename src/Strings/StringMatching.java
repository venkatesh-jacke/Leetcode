package Strings;

import java.util.*;

public class StringMatching {
    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(words));
    }

    static public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (i != j && words[j].contains(words[i]) && !res.contains(words[i])) {
                    res.add(words[i]);
                }
            }
        }
        return res;
    }
}
