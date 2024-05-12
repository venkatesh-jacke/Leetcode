

//931. Minimum Falling Path Sum

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> ranked= new ArrayList<>(Arrays.asList(100,100,50,40,40,20,10));
        List<Integer> player= new ArrayList<>(Arrays.asList(5,25,50,105));
        System.out.println(climbingLeaderboard(ranked,player));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> res = new ArrayList<>();

        int rank[] = new int[201];

        int ranking = 1;

        for (int i = 1; i < ranked.size() ; i++) {
            if (ranked.get(i-1) != ranked.get(i )) {
                rank[ranked.get(i-1)] = ranking++;
            }
        }
        rank[ranked.get(ranked.size()-1)] = ranking++;
        int newRank=1;
        for(int i=200;i>=0;i--){
            while(i>=0 && rank[i]==0){
                rank[i]=newRank;
                i--;
            }
            if(newRank==2){
                System.out.println("rank2");
            }
            newRank++;

        }
        for(int i:player){
            res.add(rank[i]);
        }
        return res;
    }

}