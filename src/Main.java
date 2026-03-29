import org.w3c.dom.css.CSSStyleRule;

import java.util.*;
import java.util.HashMap;

//2342. Max Sum of a Pair With Equal Sum of Digits
class Main {

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("222"));
    }

   static public String largestGoodInteger(String num) {
        int len = num.length();
        int max = -1;
        String res = "";
        for (int i = 0; i <= len - 3; i++) {
            String sub=num.substring(i, i + 3);
            if (isSame(sub) && Integer.parseInt(sub) > max) {
                res = num.substring(i, i + 3);
                max=Integer.parseInt(sub);
            }
        }
        return res;
    }
    public static boolean isSame(String sub){
        return sub.charAt(0)==sub.charAt(1) && sub.charAt(1)==sub.charAt(2);
    }

}