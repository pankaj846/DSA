https://leetcode.com/problems/minimum-path-sum/submissions/


class Solution {
    public int minPathSum(int[][] grid) {
        int storage[][] = new int[grid.length][grid[0].length];
        return minPathSum(grid, 0, 0, storage);
    
    }
    
     public int minPathSum(int[][] grid, int i, int j, int [][]storage){
         int m = grid.length;
         int n = grid[0].length;
         
         if(i==m-1 && j==n-1){
             storage[i][j] = grid[i][j];
             return storage[i][j];
         }
         
         if(i>=m || j>=n)
             return Integer.MAX_VALUE;
         
            if(storage[i][j]!=0)
             return storage[i][j];
         
         int path1 = minPathSum(grid, i+1, j,storage);
         int path2 = minPathSum(grid, i, j+1,storage);
         
         storage[i][j] = grid[i][j] + Math.min(path1, path2 );
         return storage[i][j];
     }
    
}
