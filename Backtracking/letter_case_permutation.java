https://leetcode.com/problems/letter-case-permutation/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        letterCasePermutation(S, list, 0);
        return list;

    }
    
    public void letterCasePermutation(String s, List<String> list, int i){
    
        if(i==s.length()){
            list.add(s);
            return;
        }
    
      if(Character.isLetter(s.charAt(i))){
          char c = s.charAt(i);
          String left = s.substring(0,i);
          String right = s.substring(i+1);
          String rest = left + right;
          letterCasePermutation(left + Character.toLowerCase(c) + right, list, i+1);
          letterCasePermutation(left + Character.toUpperCase(c) + right, list, i+1);
      }
        
        else
            letterCasePermutation(s, list, i+1);
    
   }
}
