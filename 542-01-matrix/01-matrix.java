class Solution {
    int d[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    
                    dist[i][j]=0;
                    q.add(new int[]{i,j});
                }
                else dist[i][j]=-1;
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int dx[]:d){
                    int dr=dx[0]+r;
                    int dc=c+dx[1];
                    if(dr<0 || dr>=m || dc<0 || dc>=n)continue;
                    if(dist[dr][dc]==-1){
                        dist[dr][dc]=dist[r][c]+1;
                        q.add(new int[]{dr,dc});
                    }
                }
            }
        }
        return dist;
    }
}