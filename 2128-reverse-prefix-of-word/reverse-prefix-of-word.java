class Solution {
    public String reversePrefix(String word, char ch) {
        int n=word.length();
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            if(word.charAt(i)==ch){
                end=i;
                break;
            }
        }
        StringBuilder sb=new StringBuilder(word);
        while(start<=end){
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
        return sb.toString();
    }
}