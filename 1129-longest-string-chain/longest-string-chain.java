class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a.length()!=b.length())return a.length()-b.length();
            return a.compareTo(b);
        });
        int max=1;
        int n=arr.length;
        int lastIndex=0;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int hash[]=new int[n];
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(compare(arr[i],arr[prev]) && dp[i]<dp[prev]+1){
                    dp[i]=dp[prev]+1;
                    hash[i]=prev;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastIndex=i;
            }
        }
        return max;
    }
    public boolean compare(String s1,String s2){
        if(s1.length()!=s2.length()+1)return false;
        int first=0;
        int last=0;
        while(first<s1.length()){
            if(last<s2.length() && s1.charAt(first)==s2.charAt(last)){
                first++;
                last++;
            }
            else {
                first++;
            }
        }
        if(first==s1.length() && last==s2.length())return true;
        return false;
    }
}