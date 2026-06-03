import org.w3c.dom.css.CSSStyleRule;

import java.util.*;
import java.util.HashMap;

//2342. Max Sum of a Pair With Equal Sum of Digits
class Main {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
    static public int compress(char[] chars) {
        int[] freq = new int[26];
        for(char c:chars){
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                sb.append(i+'a');
                sb.append(freq[i]);
            }
        }
        return sb.length();
    }
}