package Arrays.Matrix;

public class MaxMoves {
    public static void main(String[] args) {

    }
    static public int maxMoves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int max=0;
        int[][] dir={{-1,1},{0,1},{1,1}};
        for(int i=0;i<n;i++){
            int cur=grid[0][i];
            int count=0;
            for(int[] d:dir){
                int r=i+d[0];
                int c=i+d[1];
                if(r<m &&c <n && grid[r][c]> cur){
                    count++;
                }
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
