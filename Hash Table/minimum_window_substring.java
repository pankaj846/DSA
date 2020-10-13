https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
       String ans ="";
        
        if(s.length()<t.length())
            return ans;
        
       HashMap<Character, Integer> map2 = new HashMap<>();
       for(int i=0; i<t.length(); i++){
           char ch = t.charAt(i);
           map2.put(ch, map2.getOrDefault(ch,0)+1);
       }
       
        Map<Character, Integer> map1 = new HashMap<>();
        
       int i=-1; 
       int j=-1;
        // match count
       int mct = 0;
        // desired match count
       int dmct = t.length();
       
        while(true){
            
        boolean flag1=false;
        boolean flag2= false;  
            
        while(i<s.length()-1 && mct<dmct){
            i++;
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch,0)+1);
            
            if(map2.containsKey(ch)){
            if(map1.get(ch) <= map2.get(ch))
              mct++;     
            } 
              flag1=true;
        }
        
        while(j<i && mct==dmct){
           String temp = s.substring(j+1,i+1);
            
            if(ans.length()==0 || temp.length()<ans.length())
             ans = temp;
            
           j++;
           char ch= s.charAt(j);
            if(map1.get(ch)==1)
                map1.remove(ch);
            else
                map1.put(ch, map1.get(ch)-1);
            
            if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0))
                mct--;
            
            flag2= true;
        }
        
           if(flag1==false && flag2==false)
               break;
      }
        
        return ans;
        
    }
}
