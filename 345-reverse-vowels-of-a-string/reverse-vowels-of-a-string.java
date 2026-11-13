class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> list=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch=Character.toLowerCase(ch1);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                list.add(ch1);
            }
        }
        Collections.reverse(list);
        int i=0;
        StringBuilder sb=new StringBuilder(s);
        for(int j=0;j<n;j++){
            char ch1=sb.charAt(j);
            char ch=Character.toLowerCase(ch1);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                sb.setCharAt(j,list.get(i));
                i++;
            }
        }
        return sb.toString();
    }
}