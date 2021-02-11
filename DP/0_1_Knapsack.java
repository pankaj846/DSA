//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#

// time -> O(N*W)
class Knapsack 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int w, int wt[], int val[], int n) { 
        int memo[][] = new int[n+1][w+1];
        return helper(0, w, wt, val, n, memo) ;
    } 
    
    private static int helper(int i, int w, int wt[], int val[], int n, int memo[][]){
        if(w<0) return Integer.MIN_VALUE;
        
        // base case - when no item are left
        if(i==n || w==0) return 0;
        
        if(memo[i][w]>0) return memo[i][w];
        
        int op1 = val[i] + helper(i+1, w-wt[i], wt, val, n, memo); // include
        int op2 = helper(i+1, w, wt, val, n, memo);  // exclude
        
        return memo[i][w] = Math.max(op1, op2);
    } 
}
