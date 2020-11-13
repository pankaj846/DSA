https://leetcode.com/problems/maximal-square/


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;
        int memo[][] = new int[m][n];
        int max = 0;
        
        for(int i=0; i<m; i++)
          for(int j=0; j<n; j++){
              if(matrix[i][j]=='1')
              max = Math.max(max, helper(matrix, i, j, memo));
        }
        return max*max;
    }
    
    public int helper(char matrix[][] , int i, int j, int [][] memo){
    
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j]=='0')
            return 0;
        
        if(memo[i][j]>0)
            return memo[i][j];
        
        int op1 = helper(matrix, i, j+1, memo);
        int op2 = helper(matrix, i+1, j+1, memo);
        int op3 = helper(matrix, i+1, j, memo);
        
        memo[i][j] = 1 + Math.min(op1, Math.min(op2, op3));
        return memo[i][j];      
    }  
}
