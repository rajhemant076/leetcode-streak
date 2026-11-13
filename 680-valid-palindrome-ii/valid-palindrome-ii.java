class Solution {
    public boolean validPalindrome(String s) {
        int n=s.length();
        int start=0;
        int end=n-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return isPallindrome(s,start+1,end) || isPallindrome(s,start,end-1);
            }
            start++;
            end--;

        }
        return true;
    }
    public boolean isPallindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}