class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list=new ArrayList<>();
        List<Integer> K=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==key)K.add(i);
        }
        
        for(int i=0;i<n;i++){
            int ans=Integer.MAX_VALUE;
            for(int j=0;j<K.size();j++){
                ans=Math.min(ans,Math.abs(i-K.get(j)));
             }
             if(ans<=k)list.add(i);

        }
        return list;

    }
}