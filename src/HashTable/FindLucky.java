package HashTable;

import java.util.*;

public class FindLucky {
    public static void main(String[] args) {

    }
    static   public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans=-1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()==entry.getValue()){
                if(entry.getKey()>ans){
                    ans=entry.getKey();
                }
            }
        }
        return ans;
    }
}
