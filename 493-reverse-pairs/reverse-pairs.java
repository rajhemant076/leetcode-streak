class Solution {
    int count=0;
    public int reversePairs(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return count;

        
    }

    public void mergesort(int arr[],int low,int high){
        if(low>=high)return;
        int mid=low+(high-low)/2;
        mergesort(arr,low,mid);
        mergesort(arr,mid+1,high);
        countpairs(arr,low,mid,high);
        merge(arr,low,mid,high);
    }
    public void merge(int arr[],int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int k=0;
        int temp[]=new int[high-low+1];
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k++]=arr[left++];
            }
            else {
                temp[k++]=arr[right++];
            }

        } 
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while(right<=high){
            temp[k++]=arr[right++];
        }
        for(int i=0;i<temp.length;i++){
            arr[low+i]=temp[i];
        }
    }

    public void countpairs(int arr[],int low,int mid,int high){
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)arr[i]>2L*arr[right])right++;
            count+=(right-(mid+1));
        }
        
    }
}