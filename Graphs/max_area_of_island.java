https://leetcode.com/problems/max-area-of-island/

class Solution {
    int count=0;
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    DFS(grid, i, j);
                    max = Math.max(max,count);
                }
                count=0;
            }
        }
        
        return max;
    }
    
    
    private void DFS(int[][] grid, int i, int j){
       
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 ){
            return;
        }
        grid[i][j]=0;
         count++;
       
        DFS(grid, i+1, j);
        DFS(grid, i-1, j);
        DFS(grid, i, j-1);
        DFS(grid, i, j+1);
        
        
        
    }
    
}
