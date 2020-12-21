https://practice.geeksforgeeks.org/problems/stock-span-problem/0


static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
        // Nearest Greater to Left
        public static int[] NGL(int arr[]){
         int ans[] = new int[arr.length];
		 Stack<Pair> st = new Stack<>();
		 ans[0]=-1;
		 st.push(new Pair(arr[0], 0));
		 
		 for(int i=1; i<arr.length; i++) {
		     
		     while(st.size()>0 && arr[i]>=st.peek().first){
		         st.pop();
		     }
		     
		     if(st.size()==0) ans[i]=-1;
		     
		     else{
		         ans[i]=st.peek().second;
		     }
		     
		     st.add(new Pair(arr[i], i));
		  }
			 
		  return ans;
        }
    
    	public static int[] stockSpan(int arr[] ) {
		
	     int NGL[] = NGL(arr);
		 int res[] = new int[arr.length];
		 
		 for(int i=0 ; i < arr.length; i++){
            res[i] = i - NGL[i];			 
		 }
		  return res;
	  }	
