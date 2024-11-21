package Arrays.BinarySearch;

//2064. Minimized Maximum of Products Distributed to Any Store
public class MinimizedMaximum {
    public static void main(String[] args) {
        int n = 6;
        int quantities[] = {11, 6};
        System.out.println(minimizedMaximum(n, quantities));
    }

    static public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int i : quantities) {
            max = Math.max(i, max);
        }
        int l = 1, r = max, res = 0;
        while (l <= r) {
            int x = l + (r - l) / 2;
            if (canDistribute(x, quantities, n)) {
                res = x;
                r = x - 1;
            } else {
                l = x + 1;
            }
        }
        return res;
    }

    static public boolean canDistribute(int x, int[] quantities, int n) {
        int stores = 0;
        for (int i : quantities) {
            stores += (i + (x - 1)) / x;
        }
        return stores <= n;
    }
}
