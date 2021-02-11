https://leetcode.com/problems/partition-equal-subset-sum/submissions/

class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
       for(int a: arr)
           sum += a;
        
        if(sum%2!=0)  // if sum is odd return false
            return false;
        else
            return subSetSum(arr, sum/2);        
    }
    
    public boolean subSetSum(int arr[], int sum){
        int n = arr.length;
        Map<String, Boolean> map = new HashMap<>();        
        return helper(arr, sum ,0 , n, map);
    }
    
    private boolean helper(int arr[], int sum, int i, int n, Map<String, Boolean> map){                 
        
        if(sum==0) return true; // base case
        
        if(i>=n || sum<0) return false;
        
        String key = i + "pankaj" + sum;        
        if(map.containsKey(key)) return map.get(key);
                   
        boolean res = helper(arr, sum-arr[i], i+1, n, map) ||  helper(arr, sum, i+1, n, map);
        
        map.put(key, res);
        return res;
    }        
}
