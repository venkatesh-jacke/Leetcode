import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15,4));

    }


    static public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles / numExchange != 0) {
            ans += numBottles / numExchange;
            numBottles = numBottles % numExchange + numBottles / numExchange;

        }
        return ans;
    }

}
