https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    
    static class Pair implements Comparable<Pair>{
        int first;
        int second[];
        Pair(int first, int second[]){
          this.first = first;
          this.second = second;
        }
        
        public int compareTo(Pair o){
            return this.first - o.first;
        }
        
    }
    
    public int[][] kClosest(int[][] arr, int k) {
        int n = arr.length;
        int dist[] = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // calculate distance between them
        for(int i=0; i<n; i++)
            dist[i] = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
        
        
        for(int i=0; i<arr.length; i++){
            pq.add(new Pair(dist[i], arr[i] ));
            
            if(pq.size()>k)
                pq.remove();
        }    
    
        
        int ans[][]= new int[k][2];
        int i=0;
     
        while(!pq.isEmpty()){
          ans[i] = pq.remove().second;
            i++;
        }
        
        return ans;
        
        
    }
}
