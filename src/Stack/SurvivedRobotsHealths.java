package Stack;


import java.util.*;

//2751. Robot Collisions
public class SurvivedRobotsHealths {

    static class Robot implements Comparable<Robot> {
        int id;

        int pos;
        int health;
        char dir;

        public Robot(int id, int pos, int health, char dir) {
            this.id = id;
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "id:" + this.id + " " + "pos:" + this.pos + " " + "health:" + this.health + " " + "dir:" + this.dir;
        }

        @Override
        public int compareTo(Robot other) {
            return Integer.compare(this.pos, other.pos);
        }
    }

    public static void main(String[] args) {
        int[] pos = {3, 5, 2, 6};
        int[] health = {10, 10, 15, 12};
        String dir = "RLRL";
        System.out.println(survivedRobotsHealths(pos, health, dir));
    }

    static public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
        int n = positions.length;
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (l, r) -> Integer.compare(positions[l], positions[r]));

        for (int cur : indices) {
            if (dir.charAt(cur) == 'R') {
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && healths[cur] > 0) {
                    int top = stack.pop();
                    if (healths[top] > healths[cur]) {
                        healths[top] -= 1;
                        healths[cur] = 0;
                        stack.push(top);

                    } else if (healths[top] < healths[cur]) {
                        healths[cur] -= 1;
                        healths[top] = 0;
                    } else {
                        healths[cur] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(healths));
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }
        return res;

    }


}

