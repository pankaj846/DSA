https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
     
       List<List<Integer>> res = new ArrayList<>();
       permute(nums, new ArrayList<>(), res, 0);
        return res;
    }
    
    public void permute(int arr[], List<Integer> curr, List<List<Integer>> res, int idx){
        
        if(idx==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            
            if(curr.contains(arr[i])) 
            continue;
            
            curr.add(arr[i]);
            permute(arr, curr, res, idx+1);
            curr.remove(curr.size()-1);
        }
        
    }
    
}
