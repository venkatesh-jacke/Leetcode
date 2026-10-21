import org.w3c.dom.css.CSSStyleRule;

import java.util.*;
import java.util.HashMap;


//3069. Distribute Elements Into Two Arrays I

class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(resultArray(new int[]{5, 4, 3, 8})));
    }

    static public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        int[] res = new int[nums.length];
        int idx=0;
        for(int i:list1){
            res[idx++]=i;
        }
        for(int i:list2){
            res[idx++]=i;
        }
        return res;
    }
}