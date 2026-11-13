class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        int n=chars.length;
        int count=1;
        for(int i=1;i<n;i++){
            if(chars[i]==chars[i-1])count++;
            else {
                sb.append(chars[i-1]);
                if(count>1)sb.append(count);
                count=1;
            }


        }
        sb.append(chars[n-1]);
                if(count>1)sb.append(count);
                count=1;
        
        for(int i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}