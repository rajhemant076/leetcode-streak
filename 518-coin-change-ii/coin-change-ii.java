class Solution {
    public int change(int amount, int[] coins) {
         int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=helper(dp,coins,coins.length,amount);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int helper(int dp[][],int coins[],int n,int amount){
         if(amount==0)return 1;
        if(n==0)return 0;
       
        if(dp[n][amount]!=-1)return dp[n][amount];
        if(amount>=coins[n-1]){
            int pick=helper(dp,coins,n,amount-coins[n-1]);
            int notpick=helper(dp,coins,n-1,amount);
            return dp[n][amount]=pick+notpick;
        }
        else {
           return dp[n][amount]=helper(dp,coins,n-1,amount);
        }

    }
}