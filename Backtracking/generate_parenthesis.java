https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // initially add ")" and put ob=1
        helper("(", n, 1, 0, res);
        return res;
    }
    
    // ob - open bracket
    // cb - closed bracket
    public void helper(String curr, int n, int ob, int cb, List<String> res){
        
        if(ob==n && cb==n){
            res.add(curr);
            return;
        }
        
        // two choices - 1) add ob  2) add cb   
        if(ob<n)
        helper(curr + "(", n , ob+1, cb, res);
        
        if(cb<ob)
        helper(curr + ")", n , ob, cb+1, res);
        
    }
}
