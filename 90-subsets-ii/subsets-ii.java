class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,new ArrayList<>(),ans);
        return ans;
        
    }
    public void helper(int ind,int arr[],List<Integer> ds,List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1])continue;
            ds.add(arr[i]);
            helper(i+1,arr,ds,ans);
            ds.remove(ds.size()-1);
        }

    }
}