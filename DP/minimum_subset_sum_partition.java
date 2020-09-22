https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1


class Solution
{
    public List<Integer> list = new ArrayList<>();
	public int minDiffernce(int arr[], int n) 
	{ 
	    int sum=0;
	    for(int a: arr)
	        sum += a;
	        
	    subsetsum(arr,  sum);
	    
	    int min = Integer.MAX_VALUE;
	    for(int i=0; i<list.size(); i++){
	       min = Math.min(min, sum-2*list.get(i));
	    }
	    
	    return min;
	    
	} 
	
	public void subsetsum(int arr[], int sum){
	   int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j==0)
                    dp[i][j]=true;
            
                else if(i==0)
                    dp[i][j]=false;
            
                else if (arr[i-1]<=j){
                    boolean op1 = dp[i-1][j-arr[i-1]];
                    boolean op2 = dp[i-1][j];
                    dp[i][j] = op1 || op2;
                }
               else
                dp[i][j] =  dp[i-1][j];        
        }
    }
	    
	    for(int j=0; j<=sum/2; j++){
	        if(dp[n][j]==true)
	            list.add(j);
	    }
	  
	    
	}
	
}
