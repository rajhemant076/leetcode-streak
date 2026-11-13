class Solution {
    public String reverseWords(String s) {
        String words[]=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        int n=words.length;
        for(int i=0;i<n;i++){
            StringBuilder str=new StringBuilder(words[i]);
            sb.append(str.reverse());
            if(i<n-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}