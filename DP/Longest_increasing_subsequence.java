https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int memo[][] = new int[nums.length][nums.length];
        return LIS(nums, -1, 0, memo);
    }
    
    public int LIS(int arr[], int prev, int curr, int memo[][]){
        if(curr==arr.length)
            return 0;
        
        if(prev!=-1 && memo[prev][curr]>0)
            return memo[prev][curr];
        
          int ans1=0;
          if( prev==-1 || arr[prev]<arr[curr])
             ans1 = 1 + LIS(arr, curr, curr+1, memo);
           
             int ans2 = LIS(arr, prev, curr+1, memo);
            
            if(prev!=-1)
            memo[prev][curr]=Math.max(ans1,ans2);
        
            return Math.max(ans1, ans2);
    }
    
    
}


