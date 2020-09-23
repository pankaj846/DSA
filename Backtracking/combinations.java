https://leetcode.com/problems/combinations/submissions/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, 1, n , k);
        return res;
    }
    
    public void backtrack(List<Integer> curr, List<List<Integer>> res, int idx, int n, int k){
            
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }
        
          for(int i=idx; i<=n; i++){
              curr.add(i);
              backtrack(curr, res, i+1, n, k);
              curr.remove(curr.size()-1);
          }
          
      }
    
}
