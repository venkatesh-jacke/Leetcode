package Strings;

import java.util.HashMap;


//771. Jewels and Stones
public class NumJewelsInStones {
    public static void main(String[] args) {
        String jewels="z";
        String stones="ZZ";
        System.out.println(numJewelsInStones(jewels,stones));
    }

    //TC O(n) n--> length of stones
    //SC O(n) -->HashMap
    static  public int numJewelsInStones(String jewels, String stones)  {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char i:stones.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int c=0;
        for(char i:jewels.toCharArray()){
            c+=map.getOrDefault(i,0);
        }
        return c;
    }

    //TC O(n*m) n--> indexOf m--->length of stones
    //SC O(1) -->HashMap
    public int numJewelsInStones2(String jewels, String stones) {
        int c=0;
        for(int i=0;i<stones.length();i++){
            if(jewels.indexOf(stones.charAt(i))!=-1)c++;
        }
        return c;
    }

}
