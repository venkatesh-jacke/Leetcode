package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//90. Subsets II
public class Subsets_II {
    static List<List<Integer>> subsets = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        Arrays.sort(arr);
        System.out.println(subsets_II(arr));
//        subsets_II_2(arr,0, new ArrayList());
//        System.out.println(subsets);
    }

    static List<List<Integer>> subsets_II(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(arr, 0, new ArrayList<>(), res);
        return res;
    }

    static void generateSubsets(int[] arr, int start, List<Integer> tempList, List<List<Integer>> res) {
        if (start == arr.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        //Take
        tempList.add(arr[start]);
        generateSubsets(arr, start + 1, tempList, res);
        tempList.remove(tempList.size() - 1);  //BackTrack

        while(start+1<arr.length && arr[start]==arr[start+1])  //I have taken first occurrence skipping the duplicates
            start+=1;

        //Not take
        generateSubsets(arr, start + 1, tempList, res);

    }

    static void subsets_II_2(int[] arr,int start,List<Integer> temp) {
        subsets.add(new ArrayList<>(temp));
        for(int i=start;i<arr.length;i++){
            if(i!=start && arr[i]==arr[i-1]) continue; //need to take the first occurrence and skip the repeated ones
            temp.add(arr[i]);
            subsets_II_2(arr,i+1,temp);
            temp.remove(temp.size()-1);  //Not Take
        }
    }
}
