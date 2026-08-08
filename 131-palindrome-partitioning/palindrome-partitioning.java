class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(0,ans,new ArrayList<>(),s);
        return ans;
        
    }

    public void helper(int index,List<List<String>> ans,List<String> temp,String s){
        if(index==s.length()){
            ans.add(new ArrayList<>(temp));
            return;

        }
        for(int i=index;i<s.length();i++){
            if(isPallindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                helper(i+1,ans,temp,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPallindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}