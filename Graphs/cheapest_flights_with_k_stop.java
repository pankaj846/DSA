https://leetcode.com/problems/cheapest-flights-within-k-stops/

class Edge{
    int src;
    int nbr;
    int cost;
    
    Edge(int src, int nbr, int cost){
        this.src=src;
        this.nbr=nbr;
        this.cost=cost;
    }
}

class Pair implements Comparable<Pair>{
    int v;
    int wsf;
    int stop;
    Pair(int v, int wsf, int stop){
        this.v=v;
        this.wsf=wsf;
        this.stop=stop;
    }
    
     public int compareTo(Pair o){
        return this.wsf - o.wsf;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       
        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<Edge>();
        }
        
        for(int[] a : flights){
            graph[a[0]].add(new Edge( a[0], a[1], a[2]) );
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();   
        q.add(new Pair(src, 0, k));
        
        while(q.size()>0){
          Pair rem = q.remove();
            
          if(rem.v==dst)
             return rem.wsf;
        
            
         if(rem.stop>=0){
             
          for(Edge e: graph[rem.v])
            q.add(new Pair(e.nbr, rem.wsf+e.cost, rem.stop-1));  
            
          }
        }
        
      return -1;  
        
    }
}
