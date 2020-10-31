class Solution {
   https://leetcode.com/problems/super-egg-drop/
  
    public int superEggDrop(int e, int f) {
        int memo[][] = new int[e+1][f+1];
        return helperMemo(e, f, memo);
    }
    
    public int helperMemo(int e, int f, int memo[][]) {
        
        if(e==1) return f;
        
        if(f==0 || f==1) return f;
        
        if(memo[e][f]>0)
            return memo[e][f];
        
        int min = Integer.MAX_VALUE;
        int low=1;
        int high=f;
        
        while(low<high){
        int mid= (low+high)/2;    
        int egg_break = 1 + helperMemo(e-1, mid-1, memo);
        int egg_not_break = 1 + helperMemo(e, f-mid, memo);
         
         // take best of worst or min of max
        min = Math.min(min, Math.max(egg_break, egg_not_break));
            
         if(egg_break<egg_not_break)  low=mid+1;
            
         else high=mid;
        }
        
        memo[e][f]=min;
        return min;
    }
}
