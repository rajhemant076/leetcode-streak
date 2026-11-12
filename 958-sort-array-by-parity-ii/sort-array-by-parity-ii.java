class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int e=0;
        int o=1;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[e]=nums[i];
                e+=2;
            }
            else {
                ans[o]=nums[i];
                o+=2;
            }
        }

        return ans;
    }
}