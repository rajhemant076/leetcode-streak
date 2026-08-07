class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]=new int[9];
        for(int i=0;i<9;i++){
            arr[i]=i+1;
        }

        List<List<Integer>> ans=new ArrayList<>();
        helper(0,arr,n,ans,new ArrayList<>(),k);
        return ans;

    }
    public void helper(int ind,int arr[],int sum,List<List<Integer>> ans,List<Integer> temp,int k){
        if(temp.size()>k || sum<0)return;
        if(sum==0 && temp.size()==k){ans.add(new ArrayList<>(temp));return;}
        for(int i=ind;i<arr.length;i++){
            if(arr[i]>sum)break;
            temp.add(arr[i]);
            helper(i+1,arr,sum-arr[i],ans,temp,k);
            temp.remove(temp.size()-1);
        }

    }
}