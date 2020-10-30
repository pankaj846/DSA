https://practice.geeksforgeeks.org/problems/inversion-of-array/0#

import java.util.*;
public class GFG {
	
	static int BIT[] = new int[10000];
	static int arr[] = new int[10000];
	
	// range sum Query
    static void update(int i, int inc, int N) {
	   while(i<=N) {
		   BIT[i] += inc;
		   i += (i&(-i));
	   }
   }
	
    // sum till ith index - O(LogN)
    static int query(int i) {
	   int ans=0;
	   while(i>0) {
		   ans += BIT[i];
		   i -= (i&(-i));
	   }
	   return ans;
   }
    
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
    
		// total test cases
		while(t-->0){
		    
		int n = s.nextInt();
    
		for(int i=1; i<=n; i++)
			arr[i]=s.nextInt();
			
	    int copy[] = new int[n];
		for(int i=1; i<=n; i++)
			copy[i-1]=arr[i];
			
		Arrays.sort(copy);
		Map<Integer, Integer> map = new HashMap<>();
			
			int val=1;
			for(int i=0; i<n; i++)
	    	  map.put(copy[i], val++);
		
		// build the BIT using update function 
		// Inversion count
	    int ans=0;
	     for(int i=n; i>=1; i--) {
	        ans += query(map.get(arr[i])-1);
		    update(map.get(arr[i]), 1, arr.length);
		   }
		
		System.out.println(ans);
		
	  }
   }

}
