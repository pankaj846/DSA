 
  public void solveSudoku(char[][] board) {   
     solveSudoku(board, 0, 0);    
    }
 
 public static void solveSudoku(int[][] board, int i, int j) {
      
     if(i==board.length){
         display(board);
            return;
        }
        
        int ni = 0; //next index i
        int nj = 0; // next index j
        
        if(j==board[0].length-1){
            ni = i+1;
            nj=0;
        }
            
        else{
            nj = j+1;
            ni=i;
        }
        
        if(board[i][j]!=0){
            solveSudoku(board, ni, nj);
        }
        else{
            for(char option=1; option<=9; option++)
            if(isValid(board,i,j, option)==true){
                board[i][j]=option;
                solveSudoku(board,ni,nj);
                board[i][j]=0;
            }
        }
        
        
    }
    
    
    public static boolean isValid(int board[][], int x , int y, int val){
        
        for(int j=0; j<board[0].length; j++){
            if(board[x][j]==val)
                return false;
        }
        
         for(int i=0; i<board.length; i++){
            if(board[i][y]==val)
                return false;
        }
        
        
        int x1 = x/3*3;
        int y1 = y/3*3;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[x1+i][y1+j]==val)
                    return false;
            }
        }
        
        return true;
    }
  
