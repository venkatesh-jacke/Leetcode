package Leetcode_75;

import java.util.ArrayList;
import java.util.List;


//1431. Kids With the Greatest Number of Candies
public class KidsWithCandies {
    public static void main(String[] args) {

    }
    static public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> res= new ArrayList<>();
        int max=0;
        for(int i:candies){
            if(i>max) max=i;
        }
        for(int i:candies){
            if(i+extraCandies>=max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;

    }
}
