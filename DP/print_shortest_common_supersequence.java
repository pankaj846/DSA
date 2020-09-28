https://leetcode.com/problems/shortest-common-supersequence/


class Solution {
    
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][]= new int[str1.length()+1][str2.length()+1];
        
        lcs(str1, str2, dp);
        String lcs = printLCS(str1, str2, dp);
        
            int i=0; int j=0;
            String res= "";
            for (char c : lcs.toCharArray() ) {
            while (str1.charAt(i) != c)
                res += str1.charAt(i++);
            while (str2.charAt(j) != c)
                res += str2.charAt(j++);
            res += c; 
            i++; j++;
        }
        
        return res + str1.substring(i) + str2.substring(j);
    }
      
     
   public void lcs(String s1, String s2, int dp[][]){
        int m= s1.length();
        int n = s2.length();
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)
                   dp[i][j]=0;

                else if(s1.charAt(i-1)==s2.charAt(j-1) )
                    dp[i][j] = 1+dp[i-1][j-1];

                else
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
    }
    
  
    public String printLCS(String s1, String s2, int dp[][]){
        int i= s1.length();
        int j = s2.length();
        String res ="";
        List<Character> list = new ArrayList<>();
        while(i>0 && j>0){

            if(s1.charAt(i-1)==s2.charAt(j-1)){
                list.add(s1.charAt(i-1));
                i--;
                j--;
            }

            else if(dp[i-1][j]>dp[i][j-1])
                 i--;

            else 
              j--;

        }

        for(int k=list.size()-1; k>=0; k--){
           res += list.get(k);
       }

        return res;
    }
    
 }
