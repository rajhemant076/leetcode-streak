class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean board[][]=new boolean[n][n];
        List<List<String>> list=new ArrayList<>();
        NQueens(board,0,list);
        return list;
        

        
    }

    public void NQueens(boolean board[][],int row,List<List<String>> ans){
        if(row==board.length){
            ans.add(display(board));
            return ;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                NQueens(board,row+1,ans);
                board[row][col]=false;
            }
        }

    }
    public List<String> display(boolean board[][]){
        List<String> list=new ArrayList<>();
        for(int i=0;i<board.length;i++){
                    StringBuilder sb=new StringBuilder("");

            for(int j=0;j<board.length;j++){
                if(board[i][j]){
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
                
            }
            list.add(sb.toString());
        }
        return list;
    }

    public boolean isSafe(boolean[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col])return false;
        }
            int maxLeft=Math.min(row,col);
            for(int i=0;i<=maxLeft;i++){
                if(board[row-i][col-i]){
                    return false;
                }
            
        }
        int maxRight=Math.min(row,board.length-col-1);
        for(int i=0;i<=maxRight;i++){
            if(board[row-i][col+i])return false;
        }
        return true;

    }
}