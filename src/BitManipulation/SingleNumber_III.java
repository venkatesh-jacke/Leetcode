package BitManipulation;

import java.util.Arrays;


//260. Single Number III
public class SingleNumber_III {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    static public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xy = 0;
        for (int i : nums) {
            xy ^= i;
        }
        int rightMostSetBit = xy & (-xy);
        for (int i : nums) {
            if ((i & rightMostSetBit) == 0) {
                ans[0] ^= i;
            } else {
                ans[1] ^= i;
            }
        }
        return ans;
    }
}

/*
xy = 3^5 = 6  (0110)
3 - 0011
(^)
5 - 0101
---------
6 - 0110

rightMostSetBit - 0010

totalXor = 6

1 - 0001
2 - 0010
3 - 0011
3 - 0101

Group 1 (0010):- {2,2,3}  2 will get cancel 3 remains
Group 2 (0000):- {1,1,5}  1 will get cancel 5 remains
*/
