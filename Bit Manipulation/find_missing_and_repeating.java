https://practice.geeksforgeeks.org/problems/find-missing-and-repeating/0

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int xor=0;
        for(int a: arr)
            xor ^= a;
            
        for(int i=1; i<=arr.length ;i++)
            xor ^= i;
        
        int rsbm = xor & -xor;   
        int x=0;
        int y=0;
        
        for(int a: arr){
            if( (a & rsbm)==0)
            x ^= a;
            else
            y ^= a;
        }
       
         for(int i=1; i<=arr.length; i++){
            if( (i & rsbm)==0)
            x ^= i;
            else
            y ^= i;
        }
         for(int a: arr){
         if(a==x) 
         return new int[]{x,y};

         else if(a==y)
         return new int[]{y,x};
         
         }
         return new int[]{2};
    }
    
}
