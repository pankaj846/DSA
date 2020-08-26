class TopologicalSort {
    static Stack<Integer> stack = new Stack<>();
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean visited[] = new boolean[n];
        int arr[]= new int[n];
        
       for(int i=0; i<n; i++){
           
           if(!visited[i])
               DFS(adj,i,visited);
       }
         int index=0;
          while(!stack.isEmpty())
              arr[index++] = stack.pop();
              
        return arr;   
    }
    
    static void DFS(ArrayList<ArrayList<Integer>> adj, int src , boolean visited[]){
         visited[src]=true;
        for(int v: adj.get(src)){
            
            if(!visited[v])
                DFS(adj, v, visited);
        } 
        stack.push(src);
    }
}
