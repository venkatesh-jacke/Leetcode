package Arrays;


//121. Best Time to Buy and Sell Stock
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1, 2};
        System.out.println(maxProfit(prices));
    }

    static public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
