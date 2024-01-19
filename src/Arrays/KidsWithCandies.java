package Arrays;


import java.util.*;

//1431. Kids With the Greatest Number of Candies
public class KidsWithCandies {
    public static void main(String[] args) {
        int[] arr={2,3,5,1,3};
        int candies=3;
        System.out.println(kidsWithCandies(arr,candies));

    }

    //Time Complexity O(n)
    //Space Complexity O(n)
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
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
