package Recursion;


//240. Search a 2D Matrix II
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}
        };
        int target = 5;
    }
    static public boolean searchMatrix(int[][] arr, int target) {
        int r = 0, c = arr[0].length - 1;
        int row = arr.length, col = arr[0].length;
        return search2DMatrix(arr, target, 0, arr[0].length - 1, row, col);

    }

    private static boolean search2DMatrix(int[][] arr, int target, int r, int c, int row, int col) {
        if(r==row || c<0) return false;
        if(arr[r][c]==target) return true;
        else if(arr[r][c]<target)
            return search2DMatrix(arr, target, r+1, c, row, col);
        return search2DMatrix(arr, target, r, c-1, row, col);
    }
}
