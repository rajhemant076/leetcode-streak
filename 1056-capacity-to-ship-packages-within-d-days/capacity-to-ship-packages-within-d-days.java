class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=1;

        for(int i=0;i<arr.length;i++){
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(arr,mid,days)){
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;

        
    }
    public boolean isPossible(int arr[],int w,int days){
        int current=0;
        int cdays=1;

        for(int i=0;i<arr.length;i++){
            if(current+arr[i]<=w){
                current+=arr[i];
            }
            else {
                cdays++;
                current=arr[i];
            }
        }
        return cdays<=days;
    }
}