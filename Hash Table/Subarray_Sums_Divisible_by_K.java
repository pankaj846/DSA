https://leetcode.com/problems/subarray-sums-divisible-by-k/

class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cummSum =0;
        int count =0;
        map.put(0,1);
        
        for(int a: arr){
            cummSum += a;
            int rem = cummSum%k;
            if(rem<0) 
                rem += k;
            
            if(map.containsKey(rem))
                count += map.get(rem);
            
            map.put(rem, map.getOrDefault(rem,0)+1);
            
        }
        
        return count;
        
    }
}
