class Solution {
    public String makeSmallestPalindrome(String s) {
        int n=s.length();
        char arr[]=s.toCharArray();
        int start=0;
        int end=n-1;
        while(start<=end){
            if(arr[start]!=arr[end]){
                char min=(char)Math.min(arr[start],arr[end]);
                arr[start]=min;
                arr[end]=min;
              
            }
              start++;
                end--;
        }
        return new String(arr);
    }
}