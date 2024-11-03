package Strings;

public class IsCircularSentence {
    public static void main(String[] args) {
        String sentence = "leetcode";
        System.out.println(isCircularSentence(sentence));
    }

    static public boolean isCircularSentence(String sentence) {
        String[] arr= sentence.split(" ");
        int n=arr.length;
        char last=arr[n-1].charAt(arr[n-1].length()-1);
        for(int i=0;i<n;i++){
            if(arr[i].charAt(0)!=last) return false;
            last=arr[i].charAt(arr[i].length()-1);
        }
        return true;
    }
    static public boolean isCircularSentence2(String sentence) {
        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)==' ' && sentence.charAt(i-1)!=sentence.charAt(i+1)){
                return false;
            }
        }
        return sentence.charAt(0)==sentence.charAt(sentence.length()-1);
    }
}
