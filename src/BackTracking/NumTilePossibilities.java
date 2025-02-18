package BackTracking;

//1079. Letter Tile Possibilities

public class NumTilePossibilities {
    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }

    static public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return backTrack(freq);
    }

    static public int backTrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                count += 1 + backTrack(freq);
                freq[i]++;
            }
        }
        return count;
    }
}
