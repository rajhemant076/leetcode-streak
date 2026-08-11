class Solution {
    public int jump(int[] nums) {
        int left=0;
        int right=0;
        
        int jump=0;
        int n=nums.length;
        while(right<n-1){
            int farthest=0;
            for(int ind=left;ind<=right;ind++){
                farthest=Math.max(farthest,nums[ind]+ind);

            }
            left=right+1;
            right=farthest;
            jump++;

        }
        return jump;
        
    }
}