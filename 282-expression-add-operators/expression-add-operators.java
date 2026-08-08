class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans=new ArrayList<>();
        helper(num,target,0,0,0,"",ans);
        return ans;
        
    }
    public void helper(String num,long target,int index,long value,long prev,String expression,List<String> ans){
        if(index==num.length()){
            if(value==target){
                ans.add(expression);
                return ;
            }
        }
        for(int i=index;i<num.length();i++){
            if(i>index && num.charAt(index)=='0'){
                break;
            }
            String currString=num.substring(index,i+1);
            long current=Long.parseLong(currString);
            if(index==0){
                helper(num,target,i+1,current,current,currString,ans);

            }
            else {
                helper(num,target,i+1,value+current,current,expression+"+"+currString,ans);
                helper(num,target,i+1,value-current,-current,expression+"-"+currString,ans);
                helper(num,target,i+1,value-prev+prev*current,prev*current,expression+"*"+currString,ans);
            }

        }
    }
}