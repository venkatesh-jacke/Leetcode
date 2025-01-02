package TwoPointer;

import java.util.Arrays;

public class NumRescueBoats {
    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));

    }

    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] > limit)
                right--; //one person can come
            else {
                //two person can come
                left++;
                right--;

            }

            boats++; //on each placement one boat is required
        }
        return boats;


    }
}
