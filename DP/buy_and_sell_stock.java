  
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class Solution {
    
    public int maxProfit(int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        return helper(prices,0, false, 2, map);
    }
    
    public int helper(int prices[], int idx, boolean buyOrSell, int k, Map<String, Integer> map){
        
        if(idx>=prices.length || k==0)
            return 0;
        
        String key = idx+"hello"+buyOrSell+"world"+k;
        
        if(map.containsKey(key))
            return map.get(key);
        
        int profit = 0;
        
        if(buyOrSell==false){
        int buy = helper(prices, idx+1, true, k, map) - prices[idx];
        int noBuy = helper(prices, idx+1, false, k, map);
        profit = Math.max(buy, noBuy);
        }
        
        else{
            int sell = helper(prices, idx+1, false, k-1, map) + prices[idx];
            int noSell = helper(prices, idx+1, true, k, map);
            profit = Math.max(sell, noSell);
        }
        
        map.put(key, profit);
        return profit;
        
    }
 
}
