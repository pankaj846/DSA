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
	   int reset[] = new int[patternLen+1];
	   Arrays.fill(reset, -1);
	   
        // create reset table (watch coding block video)
	   int i=0, j=-1;
	   while(i<patternLen) {
		   while(j>=0 && pattern.charAt(i)!=pattern.charAt(j)) {
			   j=reset[j];
		   }
		   
		   i++;
		   j++;
		   reset[i]=j;	  
	   }

	   
	    i=0; j=0;
	   while(i<S.length()) {
		   while(j>=0 && S.charAt(i)!=pattern.charAt(j)) {
			   j=reset[j];
		   }
		   i++;
		   j++;
		   if(j==patternLen) {
			  return true;
		   }
		  
	   }
        
        return false;
	   
    }
    
    
    
}
