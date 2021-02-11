https://leetcode.com/problems/coin-change/

class Solution{
    
    public int coinChange(int coin[], int sum){
        // Minimum number of coins required to make amount 0 is 0.
        if(sum==0) return 0;
        
        int memo[][] = new int[coin.length+1][sum+1];
        int minCoins = helper(coin, 0, sum, memo);
        
        return minCoins==Integer.MAX_VALUE-1 ? -1 : minCoins;
    }   

   private int helper(int coin[], int i, int sum, int memo[][]){
       
       // Minimum number of coins required to make amount 0 is 0.
        if(sum==0) return 0;
       
       // we do not have any coin, we need infinity coins to create required sum.
        if(i==coin.length) return Integer.MAX_VALUE-1;
       
        if(sum<0) return Integer.MAX_VALUE-1;
       
        if(memo[i][sum]>0) return memo[i][sum];                
       
      //we have unlimited coins, we will keep using this coin until the amount is smaller than coin value.
        int include = 1 + helper(coin, i, sum-coin[i], memo);
        
       // skip the coin
        int exclude = helper(coin, i+1, sum, memo);
       
        int min = Math.min(include, exclude);
        return memo[i][sum] = min;
    }
}
