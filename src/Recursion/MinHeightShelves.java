package Recursion;


import java.util.HashMap;

//1105. Filling Bookcase Shelves
public class MinHeightShelves {

    static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};

        int shelfWidth = 4;
        System.out.println(minHeightShelves(books, shelfWidth));
    }

    static public int minHeightShelves(int[][] books, int shelfWidth) {
        return rec(books, shelfWidth, 0);
    }

    static int rec(int[][] books, int shelfWidth, int i) {
        if (i == books.length) return 0;
        if (cache.containsKey(i)) return cache.get(i);
        int cur_width = shelfWidth, max_height = 0, res = Integer.MAX_VALUE;

        for (int j = i; j < books.length; j++) {
            int width = books[j][0];
            int height = books[j][1];
            if (width > cur_width) break;
            cur_width -= width;
            max_height = Math.max(max_height, height);
            res = Math.min(res, max_height + rec(books, shelfWidth, j + 1));
        }
        cache.put(i, res);
        return res;
    }
}
