package TwoPointer;

import java.util.Arrays;

//1358. Number of Substrings Containing All Three Characters
public class NumberOfSubstrings {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    static public int numberOfSubstrings(String s) {
        int count = 0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 &&lastSeen[2]!=-1){
                count+= 1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
            }
        }
        return count;
    }
}
