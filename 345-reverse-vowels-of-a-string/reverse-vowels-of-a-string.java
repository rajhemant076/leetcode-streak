class Solution {
    public String reverseVowels(String s) {
        char ch[]=s.toCharArray();
        int n=s.length();
        int start=0;
        int end=n-1;
        while(start<end){
            while(start<end && !vowel(ch[start]))start++;
            while(start<end && !vowel(ch[end]))end--;
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
        return new String(ch);
    }
    public boolean vowel(char ch){
        ch=Character.toLowerCase(ch);
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')return true;
        return false;
    }
}