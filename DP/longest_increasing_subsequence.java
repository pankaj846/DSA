https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1#


class Solution { 

    static int longestSubsequence(int size, int a[]){
        // calculate LIS at each index
       int dp[] = new int[size];
       Arrays.fill(dp, 1); // at each index min 1 LIS toh hoga
       int res =1;
       
       for(int i=1; i<size; i++){
           for(int j=i-1; j>=0; j--){
               if(a[j]<a[i]){
               int possibleAns = dp[j]+1;
               dp[i] = Math.max(possibleAns, dp[i]);
              }
              res = Math.max(res, dp[i]);
           }
       }
       return res;
  }
 
