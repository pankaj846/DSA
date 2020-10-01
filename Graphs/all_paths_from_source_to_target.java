https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> pathSoFar = new ArrayList<>();
        int src=0;
        int dest = graph.length-1;
        pathSoFar.add(src);
        DFS(graph,0, dest, res, pathSoFar);
        return res;
    }
    
    public void DFS(int graph[][], int src, int dest, List<List<Integer>>res, List<Integer> pathSoFar){
        
        if(src==dest){
            res.add(new ArrayList<>(pathSoFar));
            return;
        }
        
        for(int adj: graph[src]){
            pathSoFar.add(adj);
            DFS(graph, adj, dest, res, pathSoFar);
            pathSoFar.remove(pathSoFar.size()-1);
        }
        
    }
    
}
