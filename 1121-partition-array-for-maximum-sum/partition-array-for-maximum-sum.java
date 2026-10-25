class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(0,dp,arr,k,n);
    }
    public int helper(int ind,int dp[],int arr[],int k,int n){
        if(ind==n)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int max=Integer.MIN_VALUE;
        int maxans=Integer.MIN_VALUE;
        int len=0;
        for(int j=ind;j<Math.min(ind+k,n);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=len*max+helper(j+1,dp,arr,k,n);
            maxans=Math.max(maxans,sum);
        }

        return dp[ind]=maxans;


    }
}