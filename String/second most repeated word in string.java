  
  // GFG problem - https://www.geeksforgeeks.org/second-repeated-word-sequence/
  // find second most repeated word in a array of string
  // Input : {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"}
  // Output : bbb
  
  
  public static String sol(String str[]){
		  int n= str.length;
	     Map<String, Integer> map = new HashMap<>();
            String finalAns= null;
            
	    for(int i=0; i<n; i++) 
	    	 map.put(str[i], map.getOrDefault(str[i], 0)+1);
	     
	     int first_Max=Integer.MIN_VALUE; 
	     int second_Max=Integer.MIN_VALUE;
	     
	     for(Map.Entry<String, Integer> e : map.entrySet()) {
	         
	    	 int freq = e.getValue();
	    	 if( freq > first_Max ) {
	    		 second_Max =first_Max;
	    		 first_Max = freq;
	    	 }
	    	 
	    	 else if(freq > second_Max) 
	    		 second_Max = freq;
	    	 
	     }
	     	     
	     	for(Map.Entry<String, Integer> e : map.entrySet()) {
	        int freq = e.getValue();
	    	if(freq == second_Max) {
	    	 finalAns = e.getKey();
	    		break;
	    	 }
	     }
	     
	     return finalAns;
	}
