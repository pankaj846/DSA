https://leetcode.com/problems/longest-happy-prefix/

class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
       int lps[] = new int[n+1];
	   int j=0;
        
	   for(int i=1; i<n; i++) {
		   while(j>0 && s.charAt(i)!=s.charAt(j)) {
			   j=lps[j-1];
		   }
		   
		   if(s.charAt(i)==s.charAt(j)) 
			   j++;
			   
		   lps[i]=j;	  
	   }
        
        // length of longest prefix, which also suffix
        int len=lps[n-1]; 
 
        // starting point of longest prefix
        int sp = n - len;   
        
        StringBuilder sb = new StringBuilder();
        for(int i=sp; i<n; i++)
            sb.append(s.charAt(i));
	   
        return sb.toString();
        
    }
}
