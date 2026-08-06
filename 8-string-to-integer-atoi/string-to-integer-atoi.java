class Solution {
    public int myAtoi(String s) {
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)!=' ')break;
        }
        boolean isNegative=false;
        if(i<s.length() && s.charAt(i)=='-'){
            i++;
            isNegative=true;
        }
        else if(i<s.length() && s.charAt(i)=='+')i++;
        while(i<s.length()){
            if(s.charAt(i)=='0')i++;
            else break;
        }
        long ans=0;
        for(;i<s.length();i++){
            if (!Character.isDigit(s.charAt(i)))
    return isNegative ? -(int)ans : (int)ans;
            ans=ans*10+s.charAt(i)-'0';
            if(isNegative && ans>2147483648L)return Integer.MIN_VALUE;
            else if(!isNegative && ans>Integer.MAX_VALUE)return Integer.MAX_VALUE;


        }
        return isNegative?-(int)ans:(int)ans;

        
    }
}