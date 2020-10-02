https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

class Solution {
    
    public Node findnxt(Node root){
        if(root==null) 
            return null;
        
        if(root.left!=null)
            return root.left;
        if(root.right!=null)
            return root.right;
        return findnxt(root.next);
        
    }
    
    public Node connect(Node root) {
        if(root==null)
            return null;
        
        if(root.left!=null){
            
            if(root.right!=null)
                root.left.next=root.right;
            else
                root.left.next = findnxt(root.next);
        }
      
        if(root.right!=null)
            root.right.next = findnxt(root.next);
            
        connect(root.right);
        connect(root.left);
        
        return root;
    }
  }
