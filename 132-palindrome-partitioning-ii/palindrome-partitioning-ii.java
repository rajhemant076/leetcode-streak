class Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean pal[][]=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || pal[i+1][j-1])){
                    pal[i][j]=true;
                }
            }
        }
        int dp[]=new int[n];
        Arrays.fill(dp,-1);

        return helper(0,n,s,dp,pal)-1;
        
    }
    public int helper(int i,int n,String s,int dp[],boolean pal[][]){
        if(i==n)return 0;
        // StringBuilder sb=new StringBuilder("");
        if(dp[i]!=-1)return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            // sb.append(s.charAt(j));
            if(pal[i][j]){
                int cost=1+helper(j+1,n,s,dp,pal);
                min=Math.min(min,cost);

            }
        }
        return dp[i]=min;
    }
}