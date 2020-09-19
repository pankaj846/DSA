https://practice.geeksforgeeks.org/problems/finding-the-numbers/0

class Solution
{
    public int[] singleNumber(int[] arr)
    {
        int xxory=0;
        for(int a : arr)
            xxory = xxory^a;
     
     int rsbm = xxory & -xxory;   
        int x=0;
        int y=0;
    for(int a:arr){
        if( (a& rsbm)==0)
            x = x^a;
            
        else
            y = y^a;
    }    
    if(x<y)
     return new int[]{x,y};   
     
     else
     return new int[]{y,x};
     
    }
    
    
}
