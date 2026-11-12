class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums1.length;i++)map.put(nums1[i][0],nums1[i][1]);
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i][0],map.getOrDefault(nums2[i][0],0)+nums2[i][1]);
        }
        int ans[][]=new int[map.size()][2];
        int i=0;
        for(Integer id:map.keySet()){
            ans[i][0]=id;
            ans[i][1]=map.get(id);
            i++;
            

        }
        return ans;
    }
}