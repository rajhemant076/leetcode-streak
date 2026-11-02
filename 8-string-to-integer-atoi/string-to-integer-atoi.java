class Solution {
    public int myAtoi(String s) {
    int i=0;
    while(i<s.length()){

    if(s.charAt(i)!=' ')break;
    i++;
    }
    boolean isNegative=false;
    if(i<s.length() && s.charAt(i)=='-'){i++;isNegative=true;}
    else if(i<s.length() && s.charAt(i)=='+')i++;
    while(i<s.length() && s.charAt(i)=='0')i++;
    return helper(i,s,isNegative,0);

        
    }
    public int helper(int i,String str,boolean isNegative,long ans){
        if(i>=str.length() || !Character.isDigit(str.charAt(i)))return isNegative?-(int)ans:(int)ans;
        int digit=str.charAt(i)-'0';
        ans=ans*10+digit;
        if(isNegative && ans>2147483648L)return Integer.MIN_VALUE;
        else if(!isNegative && ans>Integer.MAX_VALUE)return Integer.MAX_VALUE;

        return helper(i+1,str,isNegative,ans);

        

        
    }
}