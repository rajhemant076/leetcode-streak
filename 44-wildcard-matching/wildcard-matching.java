class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        Boolean dp[][]=new Boolean[m+1][n+1];
        return helper(s,m,p,n,dp);

    }
    public boolean helper(String s1,int m,String s2,int n,Boolean dp[][]){
        if(m==0 && n==0)return true;
        if(n==0)return false;
        if(m==0){
            if(s2.charAt(n-1)=='*'){
                return dp[m][n]=helper(s1,m,s2,n-1,dp);
            }
            return dp[m][n]=false;
        }
        if(dp[m][n]!=null)return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1) || s2.charAt(n-1)=='?'){
            return dp[m][n]=helper(s1,m-1,s2,n-1,dp);
        }
        else if(s2.charAt(n-1)=='*'){
            return dp[m][n]=helper(s1,m,s2,n-1,dp)||helper(s1,m-1,s2,n,dp);
        }
        else return dp[m][n]=false;
    }
}