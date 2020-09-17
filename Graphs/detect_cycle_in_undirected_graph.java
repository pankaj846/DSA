https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
         if(!visited[i]){
           if (dfs(g, i, visited, -1))
                return true;
         }
    }
    return false;
  }
  
  
   static boolean dfs(ArrayList<ArrayList<Integer>> g, int src, boolean visited[], int parent){
    visited[src] = true;
    for(int v : g.get(src)){
        if(!visited[v]){
            if(dfs(g, v, visited, src))
                return true;
        }
        
        else if(v!=parent)
            return true;
    }
     
     return false;
   }
}
