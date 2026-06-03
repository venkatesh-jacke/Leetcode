package SlidingWindow;

//1871. Jump Game VII
public class CanReach {
    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2, maxJump = 3;
        System.out.println(canReach(s, minJump, maxJump));
    }

    static public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        char[] ca = s.toCharArray();
        // Start index is reachable only if it is '0'
        dp[0] = ca[0] == '0';
        // Stores count of reachable indices inside current sliding window
        // Window: [i-maxJump , i-minJump]
        int reachableZeros = 0;
        for (int i = 1; i < n; i++) {
            // So when i grows, (i-minJump) enters window
            if (i >= minJump) { // to be eachable index entering sliding window
                reachableZeros += dp[i - minJump] ? 1 : 0;
            }
            // (i-maxJump-1) is now too far
            if (i > maxJump) { // to be old reachable index leaving sliding window
                reachableZeros -= dp[i - maxJump + 1] ? 1 : 0;
            }
            // Current index is reachable if:
            // 1. at least one reachable index exists in valid jump window
            // 2. current character is '0'
            dp[i] = reachableZeros > 0 && ca[i] == '0';
        }
        return dp[n - 1];
    }
}
