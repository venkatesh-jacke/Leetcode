package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//2491. Divide Players Into Teams of Equal Skill
public class DividePlayers {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 3, 4};
        System.out.println(dividePlayers3(arr));
    }


    //Time Complexity O(nlogn)
    static public long dividePlayers1(int[] arr) {
        Arrays.sort(arr);
        long res = 0;
        int i = 0, j = arr.length - 1;
        int diff = arr[j] + arr[i];
        while (i < j) {
            if ((arr[j] + arr[i]) != diff) {
                return -1;
            }
            res = res + ((long) arr[j] * arr[i]);
            i++;
            j--;
        }
        return res;
    }


    //Time Complexity O(n)
    static public long dividePlayers2(int[] arr) {
        int n = arr.length;
        int total = 0;
        int[] freq = new int[1001];
        for (int i : arr) {
            freq[i]++;
            total += i;
        }
        int target = total / (n / 2);
        if (total % (n / 2) != 0)
            return -1;
        long res = 0;
        for (int cur : arr) {
            int partner = target - cur;
            if (freq[partner] == 0)
                return -1;
            res = res + (((long) cur * partner));
            freq[partner]--;

        }
        return res / 2;

    }

    static public long dividePlayers3(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> skillMap = new HashMap<>();

        // Calculate total skill and build frequency map
        for (int s : skill) {
            totalSkill += s;
            skillMap.put(s, skillMap.getOrDefault(s, 0) + 1);
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Iterate through unique skill values
        for (int currSkill : skillMap.keySet()) {
            int currFreq = skillMap.get(currSkill);
            int partnerSkill = targetSkill - currSkill;

            // Check if valid partner skill exists with matching frequency
            if (!skillMap.containsKey(partnerSkill) || currFreq != skillMap.get(partnerSkill)) {
                return -1;
            }
            // Calculate chemistry for all pairs with this skill
            totalChemistry +=(long) currSkill * (long) partnerSkill * (long) currFreq;
        }

        // Return half of total chemistry (as each pair is counted twice)
        return totalChemistry / 2;
    }
}
