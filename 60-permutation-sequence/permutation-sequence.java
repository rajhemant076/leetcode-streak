class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            sb.append(i);
        }
        sb.append(n);
        StringBuilder ans=new StringBuilder();
        k=k-1;
        while(true){
            ans.append(sb.charAt(k/fact));
            sb.deleteCharAt(k/fact);

            if(sb.length()==0)break;
            k=k%fact;
            fact=fact/sb.length();
        }
        return ans.toString();
        
    }
}