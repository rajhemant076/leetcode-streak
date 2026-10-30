class Solution {
    int d[][]={{1,0},{0,1},{-1,0},{0,-1}};
    int count=0;
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)q.add(new int[]{i,j});
                else if(grid[i][j]==1)fresh++;
            }
            
        }

        int minutes=0;
        while(!q.isEmpty() && fresh>0 ){
            int size=q.size();
            for(int i=0;i<size;i++){
                int [] curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int[] dx:d){
                    int dr=r+dx[0];
                    int dc=c+dx[1];
                    if(dr<0 || dr>=m || dc<0 || dc>=n)continue;

                    if(grid[dr][dc]==1){
                        grid[dr][dc]=2;
                        fresh--;
                        q.add(new int[]{dr,dc});
                    }

                }
            }
            minutes++;

        }
        return fresh==0?minutes:-1;


    }
   
    
}