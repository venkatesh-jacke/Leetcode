package Strings;

import java.util.*;
//2942. Find Words Containing Character
public class FindWordsContaining  {
    public static void main(String[] args) {
        String[] words= new String[]{"leet","code"};
        char x='e';
        System.out.println(findWordsContaining(words,x));
    }
    static  public List<Integer> findWordsContaining(String[] words, char x)  {
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
