class Solution {
    int d[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean visited[][]=new boolean[m][n];
        dfs(sr,sc,image,color,visited,image[sr][sc]);
        return image;

    }
    public void dfs(int r,int c,int [][] image,int color,boolean visited[][],int cl){
        image[r][c]=color;
        visited[r][c]=true;
        for(int dx[]:d){
            int dr=r+dx[0];
            int dc=c+dx[1];
            if(dr>=0 && dr<image.length && dc>=0 && dc<image[0].length && !visited[dr][dc] && image[dr][dc]==cl){
                dfs(dr,dc,image,color,visited,cl);
            }

        }
    }
}