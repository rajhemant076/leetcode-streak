class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int p=0;
        int neg=1;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[p]=nums[i];
                p+=2;
            }
            else {
                ans[neg]=nums[i];
                neg+=2;
            }
        }
        return ans;
    }
}