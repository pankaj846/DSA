https://leetcode.com/problems/repeated-substring-pattern/submissions/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            if(n==0)
                return false; 
        
            // calculate longest prefix sum (lps) -> kmp algo
           int lps[] = new int [n+1];    
           int j=0;
           for(int i=1; i<n; i++) {
		   while(j>0 && s.charAt(i)!=s.charAt(j)) {
			   j=lps[j-1];
		   }
		   
		   if(s.charAt(i)==s.charAt(j)) 
			   j++;
			   
		   lps[i]=j;	  
	   }
        
        // length of longest prefix, that also suffix
        int len = lps[n-1];
        
        if(len==0)
            return false;
        
        else {
        if(n%(n-len)==0)
            return true;
            
        else
            return false;
        }
        
    }
}
