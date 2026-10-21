class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++)sum+=arr[i];
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
        int ans=Integer.MAX_VALUE;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<=sum;i++){
            if(dp[n][i])list.add(i);
        }
        for(int i=0;i<list.size();i++){
            ans=Math.min(ans,Math.abs(list.get(i)-list.get(list.size()-i-1)));

        }
        return ans;
    }
}