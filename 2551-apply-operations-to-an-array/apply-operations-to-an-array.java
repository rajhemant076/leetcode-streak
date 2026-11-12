class Solution {
    public int[] applyOperations(int[] nums) {
        int prev=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==prev){
                nums[i-1]=nums[i-1]*2;
                
                nums[i]=0;

            }
            prev=nums[i];

        }
        int i=-1;
        for(int j=0;j<n;j++){
            if(nums[j]==0){
                i=j;
                break;
            }
        }
        if(i==-1)return nums;
        for(int j=i+1;j<n;j++){
            if(nums[j]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        return nums;
    }
}