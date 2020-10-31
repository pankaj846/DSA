import java.util.*;

 class Triplet{
	  int gcd;
	  int x;
	  int y;
  }

   public class Extend_Euclid's_GCD {
	   	
	static Triplet gcdExtendedEuclid(int a, int b) {
		
		if(b==0) {
			Triplet myAns= new Triplet();
			myAns.gcd=a;
			myAns.x=1;
			myAns.y=0;
			return myAns;
		}
		
		Triplet smallAns = gcdExtendedEuclid(b, a%b);
		Triplet myAns= new Triplet();
		myAns.gcd = smallAns.gcd;
		myAns.x = smallAns.y;
		myAns.y = (smallAns.x - ((a/b)*(smallAns.y)));
		
		return myAns;
	}
	
	public static void main(String[] args) {
		
		Triplet ans = gcdExtendedEuclid(16,10);
		System.out.println("gcd: " + ans.gcd);
		System.out.println("x: " + ans.x);
		System.out.println("y: " + ans.y);
	}

}
