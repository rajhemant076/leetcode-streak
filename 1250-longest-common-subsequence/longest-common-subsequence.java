class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(text1,m,text2,n,dp);

    }
    public int helper(String s1,int m,String s2,int n,int dp[][]){
        if(n==0 || m==0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))return dp[m][n]=1+helper(s1,m-1,s2,n-1,dp);
        else {
            int ans1=helper(s1,m-1,s2,n,dp);
            int ans2=helper(s1,m,s2,n-1,dp);
            return dp[m][n]=Math.max(ans1,ans2);
        }
    }
}