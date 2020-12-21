 https://www.hackerrank.com/challenges/largest-rectangle/problem
 
 static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
  static int[] NSL(int arr[]){
        int n =arr.length;
        Stack<Pair> st = new Stack<>();
        int ans[] = new int[arr.length];
        st.push(new Pair(arr[0], 0));
        ans[0]=-1;
        
        for(int i=0; i<n; i++){
            while(st.size()>0 && st.peek().first>=arr[i]){
                st.pop();    
            }
            
            if(st.size()==0){
                ans[i]=-1;
            }
            
            else{
                ans[i] = st.peek().second;
            }
            st.push(new Pair(arr[i],i));
        }
      return ans;
    }
    
    static int[] NSR(int arr[]){
        int n =arr.length;
        Stack<Pair> st = new Stack<>();
        int ans[] = new int[arr.length];
        st.push(new Pair(arr[n-1], n-1));
        ans[n-1]=n;
        
        for(int i=n-2; i>=0; i--){
            while(st.size()>0 && st.peek().first>=arr[i]){
                st.pop();    
            }
            
            if(st.size()==0){
                ans[i]=n;
            }
            
            else{
                ans[i] = st.peek().second;
            }
            st.push(new Pair(arr[i],i));
        }
      return ans;
    }
    
    static long largestRectangle(int[] h) {
       int NSR[] = NSR(h);
       int NSL[] = NSL(h);
       
       for(int a: NSR) System.out.print(a+" ");
       System.out.println();
       for(int a: NSL) System.out.print(a+" ");
       
       
       long max =0;
       for(int i=0; i<h.length; i++){
           int width = NSR[i]-NSL[i]-1;
           int height = h[i];
           long a = width*height;
           max = Math.max(max, a);
       }
      return max;
    }
