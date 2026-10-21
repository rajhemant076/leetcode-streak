class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
         int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(obstacleGrid,dp,m-1,n-1,m,n);
    }
    public int helper(int [][] arr, int dp[][],int i,int j,int m,int n){
        if(i>=0 && j>=0 && arr[i][j]==1)return 0;
        if(i==0 && j==0)return 1;
        if(i<0 || j<0 )return 0;
        
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=helper(arr,dp,i-1,j,m,n)+helper(arr,dp,i,j-1,m,n);


    }
}