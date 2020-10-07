https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    
    static class Pair implements Comparable<Pair>{
        int first;
        int second;
        Pair(int first, int second){
            this.first= first;
            this.second= second;
        }
        public int compareTo(Pair o){
            return this.first-o.first;
        }
    }
    
    
    public int[] topKFrequent(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[]= new int[k];
        
        for(int a: arr)
            map.put(a, map.getOrDefault(a,0)+1);
            
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            pq.add(new Pair(e.getValue(), e.getKey()));
            
            if(pq.size()>k)
                pq.remove();
        }
        
        int i=0;
        while(!pq.isEmpty()){
            ans[i] = pq.remove().second;
            i++;
        }
        
        return ans;

    }
}
