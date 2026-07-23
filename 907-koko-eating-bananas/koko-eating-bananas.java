class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int high=arr[0];
        for(int i=1;i<arr.length;i++){
            high=Math.max(high,arr[i]);
        }
        int low=1;
        int ans=1;
        

        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(arr,mid,h)<=h){
                ans= mid;
                high=mid-1;
            }
            else if(helper(arr,mid,h)>h)low=mid+1;
            
        }
        return ans;
        
    }
    public long helper(int arr[],int mid,int h){
        long ans=0;
        for(int i=0;i<arr.length;i++){
            ans=ans+(arr[i]+mid-1L)/mid;
           

        }
       return ans;
    }
}