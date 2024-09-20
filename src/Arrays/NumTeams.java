package Arrays;

public class NumTeams {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1};
        System.out.println(numTeams(arr));
    }

    static public int numTeams(int[] rating) {
        int n = rating.length, teams = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        teams += 1;
                    }
                }
            }
        }
        return teams;
    }
}
