class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            ch=Character.toLowerCase(ch);
            if((ch>='a' && ch<='z') || (ch>='0' && ch<='9'))sb.append(ch);

        }
        return ispallindrome(sb.toString());
    }
    public boolean ispallindrome(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))return false;
        }
        return true;
    }
}