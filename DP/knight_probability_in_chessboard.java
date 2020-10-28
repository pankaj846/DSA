https://leetcode.com/problems/knight-probability-in-chessboard/

class Solution {
    
    public double knightProbability(int N, int K, int r, int c){
      Map<String, Double> memo = new HashMap<>();
      return helper(N,K,r,c,memo);      
    }
    
    public double helper(int N, int K, int r, int c, Map<String, Double> memo) {
        
        if(r<0 || c<0 || r>=N || c>=N) return 0;
        
        if(K==0) return 1;
        
        String key = K+"hello"+r+"pankaj"+c;
        if(memo.containsKey(key))
            return memo.get(key);
           
        // 8 possible moves
        double op1 = helper(N,K-1,r+2,c+1,memo);
        double op2 = helper(N,K-1,r+2,c-1,memo);
        double op3 = helper(N,K-1,r-2,c+1,memo);
        double op4 = helper(N,K-1,r-2,c-1,memo);
        double op5 = helper(N,K-1,r-1,c+2,memo);
        double op6 = helper(N,K-1,r+1,c+2,memo);
        double op7 = helper(N,K-1,r+1,c-2,memo);
        double op8 = helper(N,K-1,r-1,c-2,memo);
        
        double prob = (op1 + op2 + op3 + op4 + op5 + op6 + op7 + op8)/8;
        memo.put(key, prob);
        return prob;
    }
}
