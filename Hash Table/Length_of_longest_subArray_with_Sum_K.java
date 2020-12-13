   https://www.geeksforgeeks.org/longest-sub-array-sum-k/
   
   public static int lenOfLongerSubArray(int arr[], int k, int n){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int cumSum=0;
        
        for(int i=0; i<n; i++){
            cumSum += arr[i];
            
            if(cumSum==k){
                res = i+1;
            }
            
            if(!map.containsKey(cumSum)){
                map.put(cumSum, i);
            }
            
            if(map.containsKey(cumSum-k)){
                res = Math.max(res, i-map.get(cumSum-k));
            }
        }
        return res;
    }
    
