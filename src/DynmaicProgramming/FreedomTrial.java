package DynmaicProgramming;

public class FreedomTrial {
    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        System.out.println(findRotateSteps(ring,key));
    }

    static public int findRotateSteps(String ring, String key) {
        return solve(ring,key,0,0);
    }

    static int minDis(int ringIndex, int keyIndex, int ringLength) {
        int clockWise = Math.abs(ringIndex - keyIndex);
        int antiClockWise = ringLength - clockWise;
        return Math.min(clockWise, antiClockWise);
    }

    //Top Down
    static int solve(String ring, String key, int ringIndex, int keyIndex) {
        if (keyIndex == key.length()) return 0;
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int totalSteps = minDis(ringIndex, i, ring.length()) + 1 + solve(ring, key, i, keyIndex + 1);
                minSteps = Math.min(minSteps, totalSteps);
            }
        }
        return minSteps;
    }
}
