// https://leetcode.com/problems/reverse-words-in-a-string/
// Input: "the sky is blue"
// Output: "blue is sky the"

class Solution {
    public String reverseWords(String s) {
        
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){
                if(word.length()!=0){
                stack.add(word.toString());
                word = new StringBuilder();
                }
            }
            
            else
            word.append(c);
        }
        
        if(word.length()!=0)
        stack.add(word.toString());
        
        while(!stack.isEmpty()){
            ans.append(stack.pop());
            if(stack.size()==0) break;
            ans.append(" ");
        }
        
        return ans.toString();
        
        
    }
}
