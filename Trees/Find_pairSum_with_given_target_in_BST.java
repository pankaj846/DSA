https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1


class Solution
{
 
    public List<Integer> list = new ArrayList<>();
    
    public boolean check(List<Integer> list, int target){
        int left =0;
        int right=list.size()-1;
        
        while(left<right){
            int sum = list.get(left) + list.get(right);
            if(sum>target)
                right--;
            else if(sum<target)
                left++;
            else{
                return true;
            }    
        }
        
        return false;
    }
    
      public int isPairPresent(Node node, int target)
    {
     
        if(node ==null)
        return 0;
        
        isPairPresent(node.left, target);
        
        list.add(node.data);
        
        isPairPresent(node.right,target);
        
         if(check(list, target))
             return 1;
             
        else
        return 0;
    }
}
