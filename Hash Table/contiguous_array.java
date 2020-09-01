https://leetcode.com/problems/contiguous-array/submissions/

class Solution {
    public int findMaxLength(int[] arr) {
    
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int result=0;
        map.put(0,-1);
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0)
                arr[i]=-1;
            
            sum += arr[i];
            if(map.containsKey(sum)){
                int curr = i - map.get(sum);
                result = Math.max(result, curr);
            }
            
            else 
            map.put(sum, i);
        }
        
        return result;
        
    }
}
