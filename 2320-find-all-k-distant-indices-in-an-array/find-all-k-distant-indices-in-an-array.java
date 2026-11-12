class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            while(j<n && (nums[j]!=key || j<i-k))j++;
            if(j<n && j<=i+k)list.add(i);
        }
        return list;
    }
}