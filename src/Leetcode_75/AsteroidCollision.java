package Leetcode_75;

//735. Asteroid Collision

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {3, 5, -6, 2, -1, 4};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    static public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int a : asteroids) {
            //positive push to stack
            if (a > 0) {
                st.push(a);
            }
            //negative or oppositive direction
            else {
                while (
                        !st.isEmpty()// There is an asteroid to collide with.
                        && st.peek() > 0 // Top asteroid is moving right.
                        && a < 0
                        && st.peek() < -a // Current left-moving asteroid is larger, so it destroys the top asteroid.
                ) {
                    st.pop();
                }
                // Stack empty OR top is negative
                // No collision possible
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(a);
                }
                // Equal size -> both explode
                else if (st.peek() == -a) {
                    st.pop();
                }
            }
        }
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
