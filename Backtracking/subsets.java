https://leetcode.com/problems/subsets/submissions/

class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(arr, 0, curr, res);
        return res;
    }
    
    public void backtrack(int arr[], int idx, List<Integer> curr, List<List<Integer>> res){
        
        res.add(new ArrayList(curr));
        for(int i=idx; i<arr.length; i++){
            curr.add(arr[i]);
            backtrack(arr, i+1, curr, res);
            curr.remove(curr.size()-1);
        }
        
        
    }
    
}
