https://leetcode.com/problems/friend-circles/


class Solution {
    public int findCircleNum(int[][] adj) {
        int v = adj.length;
        int count=0;
        boolean visited[] = new boolean[v];
        for(int i = 0 ; i<v; i++){
            if(!visited[i]){
             findCircleNum(adj, i, visited);
                count++;
            }
        }
        return count;
    }
    
    public void findCircleNum(int[][] adj, int src,  boolean visited[]){
        visited[src]=true;
        int n = adj.length;
        for(int i =0 ; i<n ; i++){
            if(!visited[i])
            if(adj[src][i]==1){
                findCircleNum(adj, i, visited);
            }
        }
    }
    
}
