package Strings;

import java.util.*;

//1957. Delete Characters to Make Fancy String
public class MakeFancyString {
    public static void main(String[] args) {
        System.out.println(makeFancyString("aab"));
    }

    static public String makeFancyString(String s) {
        StringBuilder sb= new StringBuilder();
        int i=0;
        while(i<s.length()){
            char c =s.charAt(i);
            int j=i+1;
            while(j<s.length() && s.charAt(i)==s.charAt(j)){
                j++;
            }
            int diff =j-i;
            sb.append(c);
            if(diff>1){
                sb.append(c);
            }
            i=j;
        }
        return sb.toString();
    }

    static public String makeFancyString2(String s) {
        StringBuilder sb= new StringBuilder();
        char prev=s.charAt(0);
        sb.append(prev);
        int freq=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev){
                freq++;
            }
            else{
                prev=s.charAt(i);
                freq=1;
            }
            if(freq<3) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
