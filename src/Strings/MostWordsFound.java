package Strings;

public class MostWordsFound {
    public static void main(String[] args) {
        String[] sentence = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentence));
    }


    //TC O(n) no of sentence
    //SC O(1)
   static public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int l = sentence.split(" ").length;
            max = Math.max(l, max);
        }
        return max;

    }
}
