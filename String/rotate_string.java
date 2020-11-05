https://leetcode.com/problems/rotate-string/

class Solution {
    public boolean rotateString(String A, String B) {
        
        if(A.length() != B.length()) 
            return false;
        
        if(A.length()==0 && B.length()==0)
            return true;
        
        return KMP(A+A, B);
    }
    
    public boolean KMP(String S, String pattern){
       int patternLen = pattern.length();
        
       // create longest prefix suffix 
	   int lps[] = new int[patternLen+1];
	   int j=0;
	   for(int i=1; i<patternLen; i++) {
		   while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
			   j=lps[j-1];
		   }
		   
		   if(pattern.charAt(i)==pattern.charAt(j)) 
			   j++;
			   
		   lps[i]=j;	  
	   }
	   
	   
	   int i=0; j=0;
	   while(i<S.length()) {
		   if(S.charAt(i)==pattern.charAt(j)) {
			   i++; j++;
		   }
		   
		   if(j==patternLen) {
			   return true;
			   // j=lps[j-1];
		   }
		   
		   else if(i<S.length() && S.charAt(i)!=pattern.charAt(j)) {
			   if(j!=0) 
				   j=lps[j-1];
			   else 
				   i++;
		   }   
	   }
        
        return false;
	   
    }
    
    
    
}
