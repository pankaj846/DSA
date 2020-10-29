import java.util.*;
public class fenwickTree_implementation {
	
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
		System.out.println("enter the size: ");
		int n = s.nextInt();
		
		System.out.println("enter the array values:");
		for(int i=1; i<=n; i++)
			arr[i]=s.nextInt();
		
		// build the BIT using update function
		for(int i=1; i<=n; i++) {
			update(i, arr[i], arr.length);
		}
		
		
		System.out.println("enter the range (left & right):");
		int l = s.nextInt();
		int r = s.nextInt();
		
		int ans = query(r)-query(l-1);
		System.out.print(ans);

	}

}
