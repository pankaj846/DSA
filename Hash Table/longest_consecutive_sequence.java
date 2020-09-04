https://leetcode.com/problems/longest-consecutive-sequence/


class Solution {
    public int longestConsecutive(int[] arr) {
       
		Set<Integer> set = new HashSet<>();
		int maxLen =0;
		
		for(int i=0 ; i<arr.length; i++)  
			  set.add(arr[i]);
		
		
		for(int i=0 ; i<arr.length; i++) {
		
			if(!set.contains(arr[i]-1)) {
				maxLen = Math.max(maxLen, getLen(set, arr[i] ));
			}
			
		}
			return maxLen;
			
		}
		
		public static int getLen(Set<Integer> set, int j) {
			
			int len=1;
			
			while(set.contains(j+1)) {
				len++;
				j++;
			}
			
			return len;
			
		}
        
}    
