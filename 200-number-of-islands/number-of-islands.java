class Solution {
    int d[][]={{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char grid[][],int r,int c,boolean visited[][]){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length)return;
        visited[r][c]=true;
        for(int dx[]:d){
            int dr=r+dx[0];
            int dc=c+dx[1];
            if(dr>=0 && dr<grid.length && dc>=0 && dc<grid[0].length){

            
            if(!visited[dr][dc] && grid[dr][dc]=='1')dfs(grid,dr,dc,visited);
            }

        }


    }
}