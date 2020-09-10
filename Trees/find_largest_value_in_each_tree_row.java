https://leetcode.com/problems/find-largest-value-in-each-tree-row/


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        
     Queue<TreeNode> q = new LinkedList<>();
     List<Integer> res = new ArrayList<>();
       q.add(root);
        
        while(q.size()!=0){
            int len = q.size();
            int max = Integer.MIN_VALUE; 
            
            for(int i=0; i<len; i++){
                TreeNode front = q.remove();
                max = Math.max(max, front.val);
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            
            res.add(max);
            
        }
        return res;
        
    }
}
