https://www.spoj.com/ranks/AGGRCOW/

// find largest minimum distance

import java.util.*;
public class Aggressive_cow {
	
	private static boolean isValid(int[] arr, int mid, int cow) {
		// set first cow at first position
		int pos=arr[0];
		int count=1;
		
		// place remaining cow with min dist
		for(int i=1; i<arr.length; i++) {
			
			if(arr[i]-pos>=mid) {
				count++;
				pos=arr[i];
				
				if(count==cow) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static int binarySearch(int arr[], int cow ) {
		Arrays.sort(arr);
		int n = arr.length;
		if(n==0) return 0;
		
		// range of distances
		int left=1;
		int right=arr[n-1]-1;  
		int ans=0;
		
		while(left<=right) {
			// let mid is the min dist
			int mid = (left+right)/2;
			
			// isvalid means hum cows ko mid dist pr betha sakte h  
			if(isValid(arr, mid, cow)) {
				left=mid+1;
				ans = Math.max(ans, mid);
			}
			
			// mid dist pr nahi betha sakte toh dist kam krke check krenge
			else {
				right=mid-1;
			}	
		}
		
	  return ans;
	}
	
	public static void main(String[] args) {
		
	    Scanner s= new Scanner(System.in);
	    int t = s.nextInt();
	    while(t-->0){
	    int n = s.nextInt();
	    int cow = s.nextInt();
	    int arr[] = new int[n];
	    for(int i=0; i<n; i++){
	      arr[i]=s.nextInt();
	    }
		System.out.print(binarySearch(arr, cow));
	 }
  }
}
