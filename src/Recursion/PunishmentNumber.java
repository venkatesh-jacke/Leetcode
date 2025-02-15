package Recursion;

//2698. Find the Punishment Number of an Integer

public class PunishmentNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(punishmentNumber(n));
    }

    static public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String s = square + "";
            if (canPartition(s, 0, i)) {
                ans += square;
            }
        }
        return ans;

    }

    static public boolean canPartition(String s, int idx, int target) {
        if (idx == s.length()) {
            return target == 0;
        }
        int sum = 0;
        for (int i = idx; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > target)
                break;
            if (canPartition(s, i + 1, target - sum)) {
                return true;
            }
        }
        return false;
    }
}
