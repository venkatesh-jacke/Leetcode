package SlidingWindow;


//2516. Take K of Each Character From Left and Right
public class TakeCharacters {

    static int minMinutes = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String str = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(str, k));
    }

    static public int takeCharacters(String s, int k) {
        int n= s.length();
        int[] count= new int[3];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        // Check if it's possible to have at least k occurrences of each character
        for(int i:count){
            if(i<k) return -1;
        }
        int minMinute=n;
        for(int left=0,right=0;right<n;right++){
            count[s.charAt(right)-'a']--;
            while(left<=right && count[0]<k || count[1]<k || count[2]<k){
                count[s.charAt(left)-'a']++;
                left++;
            }
            minMinute=Math.min(minMinute,n-(right-left+1));
        }
        return minMinute;
    }
}
