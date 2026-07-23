class Solution {
    public int minDays(int[] arr, int m, int k) {

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
       
        int n=arr.length;
        if((long)m*k>n)return -1;
        
        for(int i=0;i<n;i++){
        
            low=Math.min(low,arr[i]);
            high=Math.max(high,arr[i]);
            }

            while(low<=high){
                int mid=low+(high-low)/2;
                boolean val=isPossible(arr,m,k,mid);
                if(val)high= mid-1;
                else low=mid+1;
            }
            return low;




        
        
    }
    public boolean isPossible(int arr[],int m,int k,int i){
            int count=0;
            int ans=0;
            int n=arr.length;
            for(int j=0;j<n;j++){
                if(arr[j]<=i){
                    count++;
                }
                else {ans+=count/k;
                    count=0;
                }
                
            }
            ans+=count/k;
            if(ans>=m)return true;
             return false;

        }
       
        
    
}