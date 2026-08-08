package Leetcode_75;

import java.util.LinkedList;
import java.util.Queue;

//649. Dota2 Senate
public class PredictPartyVictory {
    public static void main(String[] args) {
        String senate = "RDD";
        System.out.println(predictPartyVictory(senate));
    }

    static public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            if (r < d) { //r wins
                radiant.offer(r + n); // +n because place the senate at back of the queue with new index
            } else {
                dire.offer(d + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
