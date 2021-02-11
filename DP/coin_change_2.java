

//https://leetcode.com/problems/coin-change-2/

// time -> O(amount*N)

class Solution {
    public int change(int amount, int[] coins) {
        Map<String, Integer> map = new HashMap<>();
        return helper(coins, amount, 0, map);
    }
    
    private int helper(int coins[], int amount, int i, Map<String, Integer> map){
        
        if(amount==0) return 1; // get 1 way
        
        // we do not have any coin,then there is no way
        if(i>=coins.length) return 0;
    
        String key = amount + " " + i;
        if(map.containsKey(key)) return map.get(key);
         
        // if coin value greater then amount, then skip this coin
        if(coins[i]>amount)
            return helper(coins, amount, i+1, map);
        
        // we have unlimited coins, so use this coin untill amount is smaller then coin value
        int include = helper(coins, amount - coins[i], i, map);
        
        // skip this coin and move to next
        int exclude = helper(coins, amount, i+1, map);
        
        int res = include + exclude;
    
        map.put(key, res);
        return res;
    }
}
