package HashTable;
import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        int []arr= new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }

    //Time Is O(n^2)
    //Space is O(n)
    static public List<List<Integer>> threeSum(int[] arr) {
        int n= arr.length;
        List<List<Integer>> res= new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> hashSet= new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = -(arr[i]+arr[j]);
                if(hashSet.contains(third)){
                    List<Integer> li= new ArrayList<>(Arrays.asList(third,arr[i],arr[j]));
                    Collections.sort(li);
                    s.add(li);
                }
                hashSet.add(arr[j]);
            }
        }
        //System.out.println(s);
        for(List<Integer> item:s){
            res.add(item);
        }
        return  res;

    }
}
