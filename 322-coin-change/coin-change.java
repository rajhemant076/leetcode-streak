class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=helper(dp,coins,coins.length,amount);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int helper(int dp[][],int coins[],int n,int amount){
         if(amount==0)return 0;
        if(n==0)return Integer.MAX_VALUE;
       
        if(dp[n][amount]!=-1)return dp[n][amount];
        if(amount>=coins[n-1]){
            int sub=helper(dp,coins,n,amount-coins[n-1]);
            int pick=sub==Integer.MAX_VALUE?Integer.MAX_VALUE:1+sub;
            int notpick=helper(dp,coins,n-1,amount);
            return dp[n][amount]=Math.min(pick,notpick);
        }
        else {
           return dp[n][amount]=helper(dp,coins,n-1,amount);
        }

    }
}