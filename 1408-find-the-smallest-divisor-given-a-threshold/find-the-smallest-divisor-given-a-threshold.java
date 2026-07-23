class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            low=Math.min(arr[i],low);
            high=Math.max(arr[i],high);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            long val=sum(arr,mid);
            if(val<=threshold){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;

        

        
    }
    public long sum(int arr[],int v){
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+(arr[i]+v-1L)/v;
        }
        return sum;

    }
}