package TwoPointer;

//2337. Move Pieces to Obtain a String

public class CanChange {
    public static void main(String[] args) {
        String start = "_L__R__R_", target = "L______RR";
        System.out.println(canChange(start, target));
    }

    static public boolean canChange(String start, String target) {
        int sId = 0, tId = 0, n = start.length();
        while (sId < n || tId < n) {
            // Skip underscores in start
            while (sId < n && start.charAt(sId) == '_') sId++;
            // Skip underscores in target
            while (tId < n && target.charAt(tId) == '_') tId++;

            // If both reached end, transformation is valid
            if (sId == n && tId == n) return true;

            // If one string ends earlier, mismatch
            if (sId == n || tId == n) return false;

            // Compare characters
            if (start.charAt(sId) != target.charAt(tId)) return false;

            // Rule: 'L' can only move left → so its index in start must be >= index in target
            if (start.charAt(sId) == 'L' && sId < tId) return false;

            // Rule: 'R' can only move right → so its index in start must be <= index in target
            if (start.charAt(sId) == 'R' && sId > tId) return false;

            // Move to next character
            sId++;
            tId++;
        }
        return true;
    }
}
