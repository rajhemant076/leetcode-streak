class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        Arrays.fill(arr,-1);
        return helper(arr,nums,n-1);
    }
    public int helper(int arr[],int nums[],int n){
        if(n==0)return nums[0];
        if(n<0)return 0;
        if(arr[n]!=-1)return arr[n];
        int pick=nums[n]+helper(arr,nums,n-2);
        int notpick=helper(arr,nums,n-1);
        return arr[n]=Math.max(pick,notpick);

    }
}