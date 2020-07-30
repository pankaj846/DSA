import java.util.*;

public class equalSumPartition {
	

	public static boolean subSetSum( int[] arr, int sum) {
		
		int i, j;
       int n = arr.length;
        boolean t[][] = new boolean[n+1][sum+1];
        
        for(i=0 ; i <=n ; i++){
            for(j=0 ; j <=sum ; j++){
        
         if(j==0) 
        	 t[i][0] = true;
         
         else if(i==0)
        	 t[0][j]= false;
       	
         else  if(arr[i-1] <= j) {
            boolean op1 =  t[ i - 1 ][ j - arr[i-1] ];
           boolean op2 =t[i - 1][j];
            t[i][j]= op1 || op2;
        }
        
        else	
         t[i][j] = t[i-1][j];
       
        }
    }
        return t[n][sum];
        
}

	public static boolean equalSumPartition(int [] arr) {
		int sum =0;
		for(int i=0; i<arr.length; i++) {
			sum= sum + arr[i];
		}
		
		if(sum%2!=0) {
			return false;
		}
		else {
			return subSetSum(arr, sum/2);
		}
		
	}


	public static void main(String[] args) {
	
		int arr []= {1,6,2,5,4,2};
		
		
		System.out.println(equalSumPartition(arr));
		
		

	}

}
