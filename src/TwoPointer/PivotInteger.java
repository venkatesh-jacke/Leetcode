package TwoPointer;

//2485. Find the Pivot Integer
public class PivotInteger {
    public static void main(String[] args) {
        int n=8;
        System.out.println(pivotInteger(n));
    }
    static  public int pivotInteger(int n) {
        int left = 1, right = n;
        int leftSum = left, rightSum = right;
        if(n==1) return 1;
        while (left < right) {
            if (leftSum < rightSum) {
                leftSum += ++left;
            } else {
                rightSum += --right;
            }
            if (leftSum == rightSum && left+1 == right-1)
                return left+1;
        }
        return -1;
    }
}
