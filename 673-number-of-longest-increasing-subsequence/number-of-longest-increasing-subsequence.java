class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        int max=1;
        Arrays.fill(dp,1);
        int count[]=new int[n];
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(arr[prev]<arr[i] && dp[i]<dp[prev]+1){
                    dp[i]=dp[prev]+1;
                    count[i]=count[prev];
                }
                else if(arr[prev]<arr[i] && dp[i]==dp[prev]+1){
                    count[i]+=count[prev];
                }
            }
            max=Math.max(max,dp[i]);
        
        }
        int nos=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)nos+=count[i];
        }
        return nos;
    }
}