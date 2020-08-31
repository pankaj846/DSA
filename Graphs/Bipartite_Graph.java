https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    
    public boolean BFS(int[][] graph, int sv, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        color[sv]=1;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int adj : graph[curr]){
                if(color[adj]==0){
                    color[adj]=-color[curr];
                     q.add(adj);
                }
                
               else if(color[adj]==color[curr])
                    return false;
            }
        }
        return true;       
    }
    
    
    public boolean isBipartite(int[][] graph) {

        int len = graph.length;
        int color[] = new int[len]; 
        for (int i = 0; i < len; i++) {
            if(color[i]==0){
               if(BFS(graph, i,color)==false)
                   return false;
            }
         } 
           
     return true;       
            
    }   
}
            
            
