class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int d[][]={{-1,0},{0,-1},{1,0},{0,1},{1,1},{-1,-1},{-1,1},{1,-1}};
        Queue<int[]> q=new LinkedList<>();
        if(grid[0][0]==1 || grid[m-1][n-1]==1)return -1;
        q.add(new int[]{0,0,1});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] curr=q.remove();
            int r=curr[0];
            int c=curr[1];
            int dist=curr[2];
            if(r==m-1 && c==n-1)return dist;

            for(int dx[]:d){
                int dr=r+dx[0];
                int dc=c+dx[1];
                if(dr<0 || dr>=m || dc<0 || dc>=n )continue;
                if(grid[dr][dc]==0 && !visited[dr][dc]){
                    q.add(new int[]{dr,dc,dist+1});
                    visited[dr][dc]=true;
                }
            }

        }
        return -1;
    }
}