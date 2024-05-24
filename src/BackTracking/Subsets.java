package BackTracking;

import java.util.ArrayList;
import java.util.List;


//78. Subsets
public class Subsets {
    static List<List<Integer>> subsets = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        //System.out.println(subsets(arr));
        subsets_2(arr,0, new ArrayList());
        System.out.println(subsets);
    }

    static List<List<Integer>> subsets(int[] arr) {
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

        //Not take
        generateSubsets(arr, start + 1, tempList, res);

    }

    static void subsets_2(int[] arr,int start,List<Integer> temp) {
        subsets.add(new ArrayList<>(temp));
        for(int i=start;i<arr.length;i++){
            temp.add(arr[i]);
            subsets_2(arr,i+1,temp);
            temp.remove(temp.size()-1);  //Not Take
        }
    }
}
