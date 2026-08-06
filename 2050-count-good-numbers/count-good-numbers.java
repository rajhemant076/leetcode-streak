class Solution {
    long Modulo=1000000007L;
    public int countGoodNumbers(long n) {
        long oddCount=0;
        long evenCount=0;
        if(n%2==0){
            evenCount=oddCount=n/2;

        }
        else {
            oddCount=n/2;
            evenCount=oddCount+1;
        }
        long ans1=helper(oddCount,4,1);
        long ans2=helper(evenCount,5,ans1);
        return (int)ans2;
        
        


        
    }
    public long helper(long p,long x,long s){
        long ans=s;
        
        while(p>0){
            if(p%2==1){
                ans=(ans*x)%Modulo;
                p-=1;
            }
            else {
                x=(x*x)%Modulo;
                p/=2;
            }
            
        }
        return ans;
        

    }
    
}