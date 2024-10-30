package DynmaicProgramming;


//1545. Find Kth Bit in Nth Binary String
public class FindKthBit {
    public static void main(String[] args) {
        int n = 4, k = 11;
        System.out.println(rec((1<<n)-1,k));
        System.out.println(findKthBit(n, k));

    }

    //Recursion
    static public char rec(int len, int k) {
        if (len == 1) return '0';
        int mid = len / 2;
        if (k <= mid) {
            return rec(mid, k);
        } else if (k > mid + 1) {
            char res = rec(mid, (1 + len) - k);
            return res == '0' ? '1' : '0'; //invert the res
        } else {
            return '1';
        }
    }

    //Bottom-Up Approach
    static public char findKthBit(int n, int k) {
        int len = (1 << n) - 1;
        boolean inverted = false;
        while (len > 1) {
            int mid = len / 2;
            if (k <= mid) {
                len = mid;
            } else if (k > mid + 1) {
                k = (1 + len) - k;
                len = mid;
                inverted = !inverted;
            } else {
               return inverted ? '0' :'1';
            }
        }
        return inverted ? '1' :'0';
    }

}