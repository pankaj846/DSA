https://www.hackerrank.com/challenges/red-knights-shortest-path/problem


public class Solution {

    static class Pair{
        int first;
        int second;
        int count;
        String move;

        Pair(int first, int second, int count, String move){
            this.first= first;
            this.second = second;
            this.count= count;
            this.move = move;
        }
    }

    static int finalCount=-1;
    static boolean visited[][] = new boolean [200][200];
    static String moves[][] = new String [200][200];
    static LinkedList<String> path = new LinkedList<>();

    
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
       
        BFS(i_start, j_start, i_end, j_end, n);
        
        if(finalCount==-1)
           System.out.print("Impossible");
        
        else {
            System.out.println(finalCount);
            Stack<String> stack = new Stack<>();
            printPaths(i_end, j_end, stack);

            while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }
        
    }

    public static void BFS(int start_x, int start_y, int target_x, int target_y, int n){

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start_x, start_y, 0, ""));

        while(q.size()>0){

            // remove
            Pair rem = q.remove();
            int x = rem.first;
            int y = rem.second;
            int count = rem.count;
            String move = rem.move;
            
            // check isValid
            if(x<0 || y<0 || x>=n || y>=n)
                 continue;
            if(visited[x][y]==true)
                    continue;


            // mark star
            visited[x][y]= true;

            moves[x][y] = move;

            if(x==target_x && y==target_y){
                finalCount = count;
                break;
            }

            // add star
            q.add(new Pair(x-2,y-1,count+1,"UL"));
            q.add(new Pair(x-2,y+1,count+1,"UR"));    
            q.add(new Pair(x,y+2,count+1,"R"));
            q.add(new Pair(x+2,y+1,count+1,"LR"));
            q.add(new Pair(x+2,y-1,count+1,"LL"));
            q.add(new Pair(x,y-2,count+1,"L"));

                }
                
        }
     

    
        public static void printPaths(int x, int y, Stack<String> stack){
            
            while(finalCount!=0){

                stack.add(moves[x][y]);  

                if(moves[x][y]=="UL"){
                    x +=2;
                    y++;

                }

                else if(moves[x][y]=="UR"){
                    x +=2;
                    y--;
            
                }

                else if(moves[x][y]=="R"){
                    y -=2;
                }

                 else if(moves[x][y]=="LR"){
                    x -=2;
                    y -=1;
                    
                }

                else if(moves[x][y]=="LL"){
                    y +=1;
                    x -=2;   
                }

                 else if (moves[x][y]=="L"){
                    y +=2;
                }

                finalCount--;   

            }


        }
    
