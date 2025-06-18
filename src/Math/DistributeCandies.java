package Math;

//https://leetcode.com/problems/distribute-candies-among-children-i/
public class DistributeCandies {
    public static void main(String[] args) {
        int n = 3;
        int limit = 3;
        System.out.println(distributeCandies(n, limit));
    }

    static public int distributeCandies(int n, int limit) {
        int ways = 0;
        for (int child1 = 0; child1 <= Math.min(limit, n); child1++) {
            for (int child2 = 0; child2 <= Math.min(limit, n - child1); child2++) {
                int child3 = n - child1 - child2;
                if (child3 >= 0 && child3 <= limit)
                    ways++;
            }
        }
        return ways;
    }
}
