package Recursion;

import java.util.ArrayList;
import java.util.List;

public class StudentRecord_II {
    static int MOD = 1000000007;
    static int[][][] memo;
    static List<String> records;

    public static void main(String[] args) {
        int n = 3;
        records = new ArrayList<>();

        System.out.println(checkRecord(n));
        System.out.println(records);
    }


    static public int checkRecord(int n) {
        memo = new int[n + 1][2][3];
        return rec(n, new StringBuilder(), 0, 0);
    }

    static public int rec(int n, StringBuilder record, int absentCount, int consLeaveCount) {
        if (n == 0) {
            records.add(record.toString());
            return 1;
        }
        if (memo[n][absentCount][consLeaveCount] != 0)
            return memo[n][absentCount][consLeaveCount];

        //Initialize the ans here with result of P because we can add P always no limitations reset the count of L to 0 because i am present today
        int ans = rec(n - 1, record.append('P'), absentCount, 0) % MOD;
        record.deleteCharAt(record.length() - 1);


        //If there is no A in previous record than only add A means count must be 0
        if (absentCount < 1) {
            //Reset the L to 0 because i am absent today
            ans = (ans + rec(n - 1, record.append('A'), absentCount + 1, 0) % MOD) % MOD;
            record.deleteCharAt(record.length() - 1);
        }
        //If there is less than one  'L' in previous record than only add L means count must be <2
        if (consLeaveCount < 2) {
            //increase the L count
            ans = (ans + rec(n - 1, record.append('L'), absentCount, consLeaveCount + 1) % MOD) % MOD;
            record.deleteCharAt(record.length() - 1);
        }
        return memo[n][absentCount][consLeaveCount] = ans % MOD;
    }
}
