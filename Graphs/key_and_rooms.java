https://leetcode.com/problems/keys-and-rooms/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        int count=0;
        for(int i=0; i<rooms.size(); i++){
            if(!visited[i]){
                DFS(rooms, i, visited);
                if(count>1) 
                    break;
                    count++; //  count no of components in a graph
           }  
           
    }

     if(count==1) return true;
        
     else return false; 
               
}    
    public void DFS(List<List<Integer>> rooms, int src, boolean visited[]){
        visited[src]= true;
        
        for(int v: rooms.get(src)){
            if(!visited[v]){
                DFS(rooms, v, visited);
            }
        }
    }
}
