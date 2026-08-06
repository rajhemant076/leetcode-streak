class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        helper(list,n,n,"");
        

        return list;
        
    }
    public void helper(List<String> list,int open,int close,String str){
        if(open==0 && close==0){
            list.add(str);
            return ;
        }
        if(open>0){
            helper(list,open-1,close,str+"(");
        }
        if(close>open){
            helper(list,open,close-1,str+")");
        }
    }
}