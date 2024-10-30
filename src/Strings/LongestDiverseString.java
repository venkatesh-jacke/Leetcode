package Strings;

import java.util.PriorityQueue;

//1405. Longest Happy String
public class LongestDiverseString {
    static class Pair {
        char ch;
        int cnt;

        Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 7;
        System.out.println(longestDiverseString(a, b, c));

    }
    static  public String longestDiverseString(int a, int b, int c) {
        int curA = 0, curB = 0, curC = 0, total = a + b + c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            //No consecutive a's  and a is max of all  (or)  a is still available and there is consecutive b or c in ans
            if ((curA != 2 && a >= b && a >= c) || (a > 0 && (curB == 2 || curC == 2))) {
                sb.append("a");
                a--; //dec its value
                curA++; //inc count of curA
                curB = 0; //reset other's count
                curC = 0;
            } else if ((curB != 2 && b >= a && b >= c) || (b > 0 && (curA == 2 || curC == 2))) {
                sb.append("b");
                b--;
                curB++;
                curA = 0;
                curC = 0;
            } else if ((curC != 2 && c >= b && c >= a) || (c > 0 && (curB == 2 || curA == 2))) {
                sb.append("c");
                c--;
                curC++;
                curA = 0;
                curB = 0;
            }
        }
        return sb.toString();
    }
}
