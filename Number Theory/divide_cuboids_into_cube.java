	 https://www.hackerearth.com/problem/algorithm/bholu-the-pandit-1/
   
   public static void main(String[] args) {
		 int mod = 1000000007;
		Scanner s = new Scanner();
		int t = s.nextInt();
		
		while(t-->0) {
		int l = s.nextInt();
		int b = s.nextInt();
		int h = s.nextInt();
					
		 int side = gcd(l, gcd(b,h));
		 		 		 
		 long num = (l / side)%mod; 
	      num = (num * b / side) % mod; 
	      num = (num * h / side) % mod;
		 
		 System.out.print(side +" ");
		 System.out.println(num%mod);
		  
		}
