class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,m-1,t,n-1,dp);
    }
    public int helper(String s1,int i,String s2,int j,int dp[][]){
        if(j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))return dp[i][j]=helper(s1,i-1,s2,j-1,dp)+helper(s1,i-1,s2,j,dp);
        else return dp[i][j]=helper(s1,i-1,s2,j,dp);
    }
}