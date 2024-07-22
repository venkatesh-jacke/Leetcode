package Arrays;

import java.util.Arrays;


//2418. Sort the People
public class SortPeople {
    public static void main(String[] args) {
        String names[] = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }

    static  public String[] sortPeople(String[] names, int[] heights){
        int n = names.length;
        Integer[] indices = new Integer[n];
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));
        for (int i = 0; i < n; i++) {
            ans[i] = names[indices[i]];
        }
        return ans;
    }
}
