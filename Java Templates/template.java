import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class template { 		

	public static void main(String[] args) {
	
		// write your code here

    }
	 
	 public static class Scanner{
		   BufferedReader br;
		   StringTokenizer st;
		   public Scanner(){
		       br = new BufferedReader(new InputStreamReader(System.in));
		   }
		   String next(){
		       try{
	    	       if(st == null || !st.hasMoreTokens()){
	    	           st = new StringTokenizer(br.readLine());
	    	       }
		       } catch (IOException e) {
		               
		       }
		       return st.nextToken();
		   }
		   int nextInt(){
		       return Integer.parseInt(next());
		   }
		   long nextLong(){
		       return Long.parseLong(next());
		   }
		   double nextDouble(){
		       return Double.parseDouble(next());
		   }
		}
	
	 public static class Pair implements Comparable<Pair> {
     int first, second;
 
     public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
     
     @Override
     public int hashCode() 
     {
         return 31 * first + second;
     }
 
    public boolean equals(Object p) {
        Pair pair = (Pair) p;
         
        if (this.first != pair.first)
            return false;
             
        return this.second == pair.second;
    }
    
    @Override
    public int compareTo(Pair p) {
        if (this.first == p.first) 
        {
            return this.second - p.second;
        }
        return this.first - p.first;
     }
  }
	 
     public static int gcd(int a, int b){
      if(b==0) return a;
      return gcd(b, a%b);
     }
	 
     public static long gcd(long a, long b){
         if(b==0) return a;
         return gcd(b, a%b);
        }
   	 
	 public static void sortDec(int arr[]) {
			 Arrays.sort(arr);
			 
			 int temp[] = arr.clone();
			 
			 for(int i=0; i<arr.length; i++) {
			  arr[i] = temp[arr.length-1-i];	 
			 }
	  }
	
	 public static void sortDec(long arr[]) {
		 Arrays.sort(arr);
		 
		 long temp[] = arr.clone();
		 
		 for(int i=0; i<arr.length; i++) {
		  arr[i] = temp[arr.length-1-i];	 
		 }
     }
	 
	 public static boolean isPrime(int n) {
		 for(int i=2; i*i<=n; i++) {
			 if(n%i==0) return false;
		 }
		 return true;
	 }
	 
	 public static boolean isPrime(long n) {
		 for(long i=2; i*i<=n; i++) {
			 if(n%i==0) return false;
		 }
		 return true;
	 }
	 
	 public static void printPrimes(int n) {
	        boolean isPrime[] = new boolean[n+1];
	        Arrays.fill(isPrime, true);
	        isPrime[0]= false;
	        isPrime[1]= false;
	        
	        for(int i=2; i*i<=n ; i++){
	            if(isPrime[i]==true){
	                
	                for(int j=i*i; j<=n ; j+=i)
	                    isPrime[j]= false;
	            }
	        }
	        
	        for(int i=0; i<=n; i++){
	            if (isPrime[i])
	             System.out.print(i+" "); 
	        }
	       
	    }

	 public static BigInteger fact(int n) {		
		 BigInteger ans = new BigInteger("1"); // initialize
		 BigInteger f = BigInteger.valueOf(n);	
		 
		 if(n==0 || n==1) return f;
		 
		 BigInteger sa = fact(n-1);	
		 return f.multiply(sa);
	 }
	 
}

