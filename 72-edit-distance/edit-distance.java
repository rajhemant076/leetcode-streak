class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(word1,m,word2,n,dp);
        
    }
    public int helper(String s1,int m,String s2,int n,int[][] dp){
        if(m==0)return n;
        if(n==0)return m;
        if(dp[m][n]!=-1)return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))return dp[m][n]=helper(s1,m-1,s2,n-1,dp);
        else {
            int add=helper(s1,m,s2,n-1,dp)+1;
            int del=helper(s1,m-1,s2,n,dp)+1;
            int rep=helper(s1,m-1,s2,n-1,dp)+1;
            return dp[m][n]=Math.min(add,Math.min(del,rep));
        } 

    }
}