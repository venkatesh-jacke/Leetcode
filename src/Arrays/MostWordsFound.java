package Arrays;


//2114. Maximum Number of Words Found in Sentences
public class MostWordsFound {
    public static void main(String[] args) {
        //String arr[] = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        String arr[] = {"please wait", "continue to fight", "continue to win"};
        System.out.println(mostWordsFound(arr));
        System.out.println(mostWordsFound2(arr));
    }


    //Time Complexity is O(n * m), where n is the number of sentences and m is the average length of a sentence.
    //Space Complexity  is O(m) due to the char[] ch array.
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String word : sentences) {
            int count = 1;
            char[] ch = word.toCharArray();
            for (char i : ch) {
                if (i == ' ') {
                    count++;
                }
                max = Math.max(max, count);
            }
        }

        return max;

    }



    //Time Complexity is O(n)
    //Space Complexity  is O(1)
    public static int mostWordsFound2(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int words = sentence.split(" ").length;
            System.out.println(sentence.toCharArray());
            if (max < words) max = words;
        }
        return max;

    }
}
