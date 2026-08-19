import org.w3c.dom.css.CSSStyleRule;

import java.util.*;
import java.util.HashMap;


class Main {

    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
        maxNumberOfFamilies(3, new int[][]{
                {1, 2},
                {1, 3},
                {1, 8},
                {2, 6},
                {3, 1},
                {3, 10}
        });
        //System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }

    static public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int[][] seats = new int[n][10];
        for (int[] rows : reservedSeats) {
            //question is 1 index we do it in 0 index
            seats[rows[0]-1][rows[1]-1] = 1;
        }
        System.out.println(Arrays.deepToString(seats));
        return -1;
    }
}