https://leetcode.com/problems/unique-binary-search-trees/


class Solution {
    public int numTrees(int n) {
        int memo[][] = new int[n+1][n+1];
        return helper(1, n, memo);
    }
    
    public int helper(int start, int end, int memo[][]){
        if(start>=end)
            return 1;
        
        if(memo[start][end]>0)
            return memo[start][end];
        
        int count=0;
        for(int i=start; i<=end; i++){
            count += helper(start, i-1, memo)*helper(i+1, end, memo);
        }
        
         memo[start][end] = count;
         return count;
    }

}
