package Arrays;

//874. Walking Robot Simulation

import java.util.HashSet;
import java.util.Set;

public class RobotSim {
    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(robotSim(commands, obstacles));
    }

    static public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //north east south west
        Set<String> obs = new HashSet<>();
        int maxDist =0;
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }
        int x = 0, y = 0; // robot starts at origin
        int dir = 0;// 0=North, 1=East, 2=South, 3=West
        for (int command : commands) {
            if (command == -1) {
                // Turn RIGHT: go forward one direction
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                // Turn LEFT: go back one direction (with wrap)
                dir = (dir + 3) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if (obs.contains(nx + "," + ny)) break;
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        return maxDist;
    }
}
