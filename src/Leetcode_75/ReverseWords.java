package Leetcode_75;

import java.util.Arrays;


//151. Reverse Words in a String
public class ReverseWords {
    public static void main(String[] args) {

    }
    static  public String reverseWords(String s) {
        String[] sa = s.trim().split("\\s+");
        int i=0,j=sa.length-1;
        System.out.println(Arrays.toString(sa));
        while(i<=j){
            String temp=sa[i];
            sa[i]=sa[j];
            sa[j]=temp;
            i++;
            j--;
        }
        return String.join(" ",sa);
    }
}
