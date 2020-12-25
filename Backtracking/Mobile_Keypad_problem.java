https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution{
    public String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits){
         if(digits.length()==0) {
         return new ArrayList<String>();
         } 
        
        List<String> res = new ArrayList<>();
        helper(digits, res, "");
        return res;
    }
    
    private void helper(String digits, List<String> res, String Asf){
        if(digits.length()==0){
            res.add(Asf);
            return;
        }
        
        int idx = digits.charAt(0)-'0';
        String charOutput = dict[idx];
        
        for(int i=0; i<charOutput.length(); i++){
            helper(digits.substring(1), res, Asf+charOutput.charAt(i));
        }
    }
}
