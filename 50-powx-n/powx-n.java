class Solution {
    public double myPow(double x, int n) {
        long p=Math.abs((long)n);
        double ans=helper(1D,p,x);
        return n<0?1/ans:ans;
        
    }
    public double helper(double ans,long p,double x){
        if(p>0){

        
        if(p%2==1){
            return helper(ans*x,p-1,x);
        }
        else {
            return helper(ans,p/2,x*x);
        }
        }
        else {
            return ans;
        }

    }
}