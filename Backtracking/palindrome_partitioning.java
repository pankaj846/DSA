https://leetcode.com/problems/palindrome-partitioning/

// time - O(N*2^N)   space - O(N)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> curr = new ArrayList<>();
        dfs(0, res, curr, s);
        return res;
    }
    
    public void dfs(int start, List<List<String>> res, List<String> curr, String s){
     
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
        }
        
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(start, i, s)){
                curr.add(s.substring(start, i+1));
            
            dfs(i+1, res, curr, s);
           // backtrack and remove current substring from curr
            curr.remove(curr.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    
}
