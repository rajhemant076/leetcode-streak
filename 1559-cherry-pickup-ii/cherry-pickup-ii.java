class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][][]=new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=-1;
            }
        }

    }
    return helper(0,0,n-1,m,n,dp,grid);
    }
    public int helper(int i,int j1,int j2,int m,int n,int[][][] dp,int grid[][]){
        if(j1<0 || j2<0 || j1>=n || j2>=n)return Integer.MIN_VALUE;
        if(i==m-1){
            if(j1==j2)return grid[i][j1];
            else {
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        int max=Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int val=0;
                if(j1==j2) val=grid[i][j1];
                else {
                    val=grid[i][j1]+grid[i][j2];
                }
                val+=helper(i+1,j1+dj1,j2+dj2,m,n,dp,grid);
                max=Math.max(max,val);

            }
        }
        return dp[i][j1][j2]=max;

    }
}