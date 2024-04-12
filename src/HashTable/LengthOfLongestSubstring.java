package HashTable;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    static public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0,len=0;
        for(int right=0;right<n;right++){
            char cur= s.charAt(right);
            if(map.containsKey(cur) && map.get(cur)>=left){
                left=map.get(cur)+1;
            }
            map.put(cur,right);
            len=Math.max(len,right-left+1);
        }

        return len;
    }
}
