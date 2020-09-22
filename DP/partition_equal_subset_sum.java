https://leetcode.com/problems/partition-equal-subset-sum/submissions/

class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
       for(int a: arr)
           sum += a;
        
        if(sum%2!=0)
            return false;
        else
            return subSetSum(arr, sum/2);
        
    }
    
    public boolean subSetSum(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++)
                if(j==0)
                    dp[i][0]=true;
            
                else if(i==0)
                    dp[0][j]=false;
            
                else if (arr[i-1]<=j){
                    boolean op1 = dp[i-1][j-arr[i-1]];
                    boolean op2 = dp[i-1][j];
                    dp[i][j] = op1 || op2;
                }
               else
                dp[i][j] =  dp[i-1][j];        
        }
    
        return dp[n][sum];
    }
    
}
