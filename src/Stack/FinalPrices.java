package Stack;

import java.util.Arrays;
import java.util.Stack;


//1475. Final Prices With a Special Discount in a Shop
public class FinalPrices {
    public static void main(String[] args) {
        int[] prices = new int[]{8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(prices)));
        System.out.println(Arrays.toString(finalPrices2(prices)));
    }


    //TC O(n^2)
    //SC O(1)
    static public int[] finalPrices(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[i]) {
                    ans[i] = arr[i] - arr[j];
                    break;
                } else {
                    ans[i] = arr[i];
                }
            }

        }
        ans[arr.length - 1] = arr[arr.length - 1];
        return ans;
    }


    //TC O(n)
    //SC O(n)
    static public int[] finalPrices2(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            //we pop the index and update the value until we see value greater tha pushing value
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int index = stack.pop();
                ans[index] = arr[index] - arr[i];
            }
            stack.push(i);
        }

        // Set final prices for elements with non-finalized prices
        while (!stack.isEmpty()) {
            int index = stack.pop();
            ans[index] = arr[index];
        }

        return ans;
    }
}