class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // List<List<Integer>> list=new ArrayList<>();
        int closest=nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];

                if(Math.abs(sum-target)<Math.abs(target-closest)){
                    closest=sum;

                }
                else if(sum<target)j++;
                else if(sum>target){
                    k--;

                }
                else {
                   return sum;



                }
            }
        }
        return closest;
    }
}