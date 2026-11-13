class Solution {
    public int[] shortestToChar(String s, char c) {
        int n=s.length();
        int ans[]=new int[n];
        int prev=-n;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                prev=i;
            }
            ans[i]=Math.abs(i-prev);
        }
        prev=2*n;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==c)prev=i;
            ans[i]=Math.min(ans[i],Math.abs(i-prev));
        }
        return ans;
    }
}