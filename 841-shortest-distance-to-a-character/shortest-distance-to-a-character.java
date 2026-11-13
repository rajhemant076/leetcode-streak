class Solution {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> index=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c)index.add(i);
        }
        int ans[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int v=Integer.MAX_VALUE;
            for(int j=0;j<index.size();j++){
                v=Math.min(v,Math.abs(i-index.get(j)));
            }
            ans[i]=v;
        }
        return ans;
        
    }
}