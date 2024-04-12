package Strings;

import java.util.Arrays;

public class DecodeMessage {
    public static void main(String[] args) {
        String key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage(key,message));
    }
   static public String decodeMessage(String key, String message) {
        char[] arr = new char[26];
        int i = 0;
        for (char c : key.toCharArray()) {
            if (i < 26 && c != ' ' && arr[c - 'a'] == 0) {
                arr[c-'a'] = (char) (i + 'a');
                i++;
            }
        }
       System.out.println(Arrays.toString(arr));
        StringBuilder ans = new StringBuilder();
        for (char c : message.toCharArray()) {
            ans.append(c == ' ' ? ' ' : arr[c - 'a']);
        }
        return ans.toString();
    }
}
