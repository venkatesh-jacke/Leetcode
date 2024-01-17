package Arrays;


import java.util.*;

//2942. Find Words Containing Character
public class FindWordsContaining {
    public static void main(String[] args) {
        String[] arr = new String[]{"leet", "code"};
        char x = 'e';
        System.out.println(findWordsContaining(arr, x));
    }

    //Time Complexity  is O(N * M), where N is the number of words in the array and M is the average length of the words
    //Space Complexity is O(N * M), and the space complexity is O(N)
    static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> l= new ArrayList<>();
        int c=0;
        for(String word:words){
            if(word.indexOf(x)>=0){
                l.add(c);
            }
            c++;
        }

        return l;
    }
}
