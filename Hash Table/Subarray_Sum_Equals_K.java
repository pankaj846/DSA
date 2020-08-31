https://leetcode.com/problems/subarray-sum-equals-k/

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int cummSum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            cummSum += nums[i];
            if (map.containsKey(cummSum - k)) {
                result += map.get(cummSum - k);
            }
            map.put(cummSum, map.getOrDefault(cummSum, 0) + 1);
        }
    
        return result;
    }
}
