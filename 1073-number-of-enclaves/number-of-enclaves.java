class Solution {
    int d[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
                for(int i=0;i<n;i++){
            if(!visited[0][i] && grid[0][i]==1)dfs(0,i,visited,grid);
            if(!visited[m-1][i] && grid[m-1][i]==1)dfs(m-1,i,visited,grid);

        }
        for(int i=0;i<m;i++){
            if(!visited[i][0] && grid[i][0]==1)dfs(i,0,visited,grid);
            if(!visited[i][n-1] && grid[i][n-1]==1)dfs(i,n-1,visited,grid);

        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1)count++;
            }
        }
        return count;


    }
    public void dfs(int r,int c,boolean visited[][],int grid[][]){
        visited[r][c]=true;
        for(int dx[]:d){
            int dr=r+dx[0];
            int dc=c+dx[1];
            if(dr>=0 && dr<grid.length && dc>=0 && dc<grid[0].length && !visited[dr][dc] && grid[dr][dc]==1){
                dfs(dr,dc,visited,grid);
            }
        }

    }
}