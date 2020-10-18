https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/


class Solution {
    public int maxProfit(int[] prices) {
    // hashmap is use for memoization
    Map<String, Integer> map = new HashMap<>();
    return helper(prices, 0, false, 0, map);    
        
    }
    
    public int helper(int prices[], int idx, boolean buyOrSell, int profit, Map<String, Integer> map){
        
        if(idx>=prices.length)
            return 0;
        
        String key = idx+""+buyOrSell;
        
        if(map.containsKey(key))
            return map.get(key);
        
        // buy
        if(buyOrSell==false){
           int buy = helper(prices, idx+1, true, profit, map) - prices[idx];
           int noBuy = helper(prices, idx+1, false, profit, map);
           profit = Math.max(buy, noBuy);
        }
        
        // sell
        else{
           int sell = helper(prices, idx+2, false, profit, map) + prices[idx];
           int noSell = helper(prices, idx+1, true, profit, map);        
           profit= Math.max(sell, noSell); 
        }
        map.put(key, profit);
        return profit;
    }

}
