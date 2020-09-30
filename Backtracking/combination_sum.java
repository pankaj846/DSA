https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void backtrack(int arr[], int target, List<List<Integer>> res, List<Integer> curr, int idx){
        
        if(target<0)
            return;
        
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        
        for(int i=idx; i<arr.length; i++){
            
            curr.add(arr[i]);
            backtrack(arr, target-arr[i], res, curr, i);
            curr.remove(curr.size()-1);
            
        }
        
    }
    
    
}
