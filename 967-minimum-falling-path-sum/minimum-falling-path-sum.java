class Solution {
    public int minFallingPathSum(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int dp[][]=new int[m][n];
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,helper(0,j,m,n,mat,dp,visited));
        }     
        return ans;
    }
    public int helper(int i,int j,int m,int n,int [][] mat,int dp[][],boolean visited[][]){
        if(i>m-1 || j<0 || j>n-1)return 1_000_000_000;
        if(i==m-1)return mat[m-1][j];
        
        if(visited[i][j])return dp[i][j];
         dp[i][j]=Math.min(mat[i][j]+helper(i+1,j,m,n,mat,dp,visited),Math.min(mat[i][j]+helper(i+1,j-1,m,n,mat,dp,visited),mat[i][j]+helper(i+1,j+1,m,n,mat,dp,visited)));
         visited[i][j]=true;
         return dp[i][j];
    }
}