class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(1,n,nums,dp);
    }
    public int helper(int i,int j,int arr[],int dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int a=i-1<0?1:arr[i-1];
            int c=j+1>=arr.length?1:arr[j+1];
            int b=ind>=arr.length?1:arr[ind];
            max=Math.max(max,a*b*c+helper(i,ind-1,arr,dp)+helper(ind+1,j,arr,dp));
        }
        return dp[i][j]=max;
    }
}