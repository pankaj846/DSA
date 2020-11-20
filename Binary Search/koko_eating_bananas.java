https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    
    // can eat all piles in H hour with speed k
    private boolean isValid(int piles[], int k, int H){
        int hours=0; // hours to eat all piles
        for(int pile : piles){
            hours += pile/k;
            if(pile%k!=0) hours++;
        }
        
        return (hours<=H);
    }
    
    
    public int minEatingSpeed(int[] piles, int H) {
        // ranges of speed
        int left=1;
        int right=0;
        for(int a: piles){
            right = Math.max(right, a);
        }
        
        int ans=right;
        while(left<=right){
            // let mid as min speed
            int mid = (left+right)/2;
            
            if(isValid(piles, mid, H)){
                // it can eat all piles with speed=mid
                // so we need more minimum speed, thats why right=mid-1
                ans = Math.min(ans, mid);
                right = mid-1;
            }
            
            // at speed=mid, not eat all piles
            // so we need to increase speed, left=mid+1
            else
                left=mid+1;
        }
        return ans;
    }
}
