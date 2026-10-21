class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        return isSubsetSum(nums,sum/2);
    }
    public boolean isSubsetSum(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                int val=arr[i-1];
                if(val<=j && dp[i-1][j-val])dp[i][j]=true;
                else if(dp[i-1][j])dp[i][j]=true;
            }
        }
        return dp[n][sum];
    }
}