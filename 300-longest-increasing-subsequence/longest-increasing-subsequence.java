class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,nums,0,-1,n);


    }
    public int helper(int dp[][],int[] nums,int ind,int pind,int n){
        if(ind==n)return 0;
        if(dp[ind][pind+1]!=-1)return dp[ind][pind+1];
        int len=helper(dp,nums,ind+1,pind,n);
        if(pind==-1 || nums[ind]>nums[pind]){
            len=Math.max(len,1+helper(dp,nums,ind+1,ind,n));
        }
        return dp[ind][pind+1]=len;
        
    }
}