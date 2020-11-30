https://leetcode.com/problems/russian-doll-envelopes/submissions/


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n==0) return 0;
        
        // sort array according width
        Arrays.sort(envelopes, (a,b) -> Integer.compare(a[0], b[0]));
        
        // apply LIS on height
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int res=1;
        
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                int possibleAns = dp[j]+1;
                dp[i] = Math.max(possibleAns, dp[i]);
                res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
