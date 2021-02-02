//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
// time - O(N*N)

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int memo[][] = new int[n+1][n+1];
        return helper(s, 0, n-1, memo);
    }
    
    private int helper(String s, int start, int end, int memo[][]){
        if(start>=end){
            return 0;
        }
        
        if(memo[start][end]!=0){
            return memo[start][end];
        }
        
        if(s.charAt(start)==s.charAt(end)){
            return helper(s, start+1, end-1, memo);            
        }
        //fix left side (by adding s.charAt(start) after "end" index).
        int op1 = 1 + helper(s, start+1, end, memo);
        
        //"fix" right side (by adding s.charAt(end) before "start" index).
        int op2 = 1 + helper(s, start, end-1, memo);
        
        return memo[start][end] = Math.min(op1, op2);        
    }
}
