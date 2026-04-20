package TwoPointer;

//2078. Two Furthest Houses With Different Colors
public class MaxDistance {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1,8,3,8,3}));
    }

    static public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }

    static public int maxDistance1(int[] colors) {
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // Case 1: compare current house with LAST house
            // if colors are different, calculate distance (n-1 - i)
            if(colors[i]!=colors[n-1]){
                res =Math.max(res,n-1-i);
            }
            // Case 2: compare current house with FIRST house
            // if colors are different, calculate distance (i - 0 = i)
            if(colors[i]!=colors[0]){
                res = Math.max(res,i);
            }
        }
        return res;
    }

}
