package Stack;


import java.util.*;

//2751. Robot Collisions
public class SurvivedRobotsHealths {

    public static void main(String[] args) {
        int[] pos = {3, 5, 2, 6};
        int[] health = {10, 10, 15, 12};
        String dir = "RLRL";
        System.out.println(survivedRobotsHealths(pos, health, dir));
    }

    static public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
        int n = positions.length;
        List<Integer> res = new ArrayList<>();
        // Stack to store indices of robots moving to the right
        Stack<Integer> stack = new Stack<>();

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        // Sort indices based on positions (important for collision order)
        Arrays.sort(indices, (l, r) -> Integer.compare(positions[l], positions[r]));

        for (int cur : indices) {
            if (dir.charAt(cur) == 'R') {
                stack.push(cur);
            } else {
                // Robot moving left → possible collisions with previous right-moving robots
                while (!stack.isEmpty() && healths[cur] > 0) {
                    int top = stack.pop(); // Last right-moving robot
                    // Case 1: Right robot stronger
                    if (healths[top] > healths[cur]) {
                        healths[top] -= 1;
                        healths[cur] = 0;
                        stack.push(top);
                    }
                    // Case 2: Left robot stronger
                    else if (healths[top] < healths[cur]) {
                        healths[cur] -= 1;
                        healths[top] = 0;
                    }
                    // Case 3: Equal health → both destroyed
                    else {
                        healths[cur] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }
        return res;

    }


}

