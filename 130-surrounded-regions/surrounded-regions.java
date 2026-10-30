class Solution {
    int d[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(board[i][j]=='O')dfs(board,i,j);
                }
                if(i==m-1){
                    if(board[i][j]=='O')dfs(board,i,j);
                }
                if(j==0){
                    if(board[i][j]=='O')dfs(board,i,j);
                }
                if(j==n-1){
                    if(board[i][j]=='O')dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#')board[i][j]='O';
                else if(board[i][j]=='O')board[i][j]='X';
            }
        }

        
    }
    public void dfs(char[][] board,int r,int c){
        board[r][c]='#';
        for(int dx[]:d){
            int dr=r+dx[0];
            int dc=c+dx[1];
            if(dr<0 || dr>=board.length || dc<0 || dc>=board[0].length)continue;
            if(board[dr][dc]=='O')dfs(board,dr,dc);
        }
    }
}