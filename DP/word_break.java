https://leetcode.com/problems/word-break-ii/

class Solution {    
    
    public HashMap<String, List<String>> map = new HashMap<>();
    
     public List<String> wordBreak(String s, List<String> wordDict) { 
         
        return wordBreak(s, wordDict, "");
        
       }
     
    
    public List<String> wordBreak(String s, List<String> wordDict, String str) {    
    
         int size = s.length();
         List<String> res = new LinkedList<>();
        
          if(map.containsKey(s))
              return map.get(s);
        
         //base case 
         if(size==0){
            res.add("");
             return res;
         }
    
        for(int i=0; i<size; i++){
            String left = s.substring(0,i+1);
            
            if(wordDict.contains(left) ){
            String right = s.substring(i+1);
              
           List<String>sublist = wordBreak(right, wordDict, str+left+" ");
                
             for (String sub : sublist) {
                 if(sub.isEmpty())
                     res.add(left + sub);
                 else
                     res.add(left+" "+ sub);
             }
                
     
            }
        }
        map.put(s, res);
        return res;
        
    }
 
    
}
