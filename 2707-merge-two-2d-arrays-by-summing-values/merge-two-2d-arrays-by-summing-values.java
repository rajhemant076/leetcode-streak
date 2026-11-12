class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        //Method 1

        // TreeMap<Integer,Integer> map=new TreeMap<>();
        // for(int i=0;i<nums1.length;i++)map.put(nums1[i][0],nums1[i][1]);
        // for(int i=0;i<nums2.length;i++){
        //     map.put(nums2[i][0],map.getOrDefault(nums2[i][0],0)+nums2[i][1]);
        // }
        // int ans[][]=new int[map.size()][2];
        // int i=0;
        // for(Integer id:map.keySet()){
        //     ans[i][0]=id;
        //     ans[i][1]=map.get(id);
        //     i++;
            

        // }
        // return ans;

        //Method 2

        // int left=0;
        // int right=0;
        // int m=nums1.length;
        // int n=nums2.length;
        // ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        // while(left<m && right<n){
        //     if(nums1[left][0]==nums2[right][0]){
        //         list.add(new ArrayList<>(Arrays.asList(nums1[left][0],nums1[left][1]+nums2[right][1])));
        //         left++;
        //         right++;
        //     }
        //     else if(nums1[left][0]<nums2[right][0]){
        //         list.add(new ArrayList<>(Arrays.asList(nums1[left][0],nums1[left][1])));
        //         left++;
        //     }
        //     else {
        //         list.add(new ArrayList<>(Arrays.asList(nums2[right][0],nums2[right][1])));
        //         right++;
        //     }

        // }
        // while(left<m){
        //     list.add(new ArrayList<>(Arrays.asList(nums1[left][0],nums1[left][1])));
        //     left++;

        // }
        // while(right<n){
        //     list.add(new ArrayList<>(Arrays.asList(nums2[right][0],nums2[right][1])));
        //     right++;
        // }
        // int ans[][]=new int[list.size()][2];
        // for(int i=0;i<list.size();i++){
        //     ans[i][0]=list.get(i).get(0);
        //     ans[i][1]=list.get(i).get(1);
        // }
        // return ans;

        //Method 3
        
        int m = nums1.length;
        int n = nums2.length;

        int[][] ans = new int[m + n][2];

        int left = 0, right = 0, k = 0;

        while (left < m && right < n) {

            if (nums1[left][0] == nums2[right][0]) {
                ans[k][0] = nums1[left][0];
                ans[k][1] = nums1[left][1] + nums2[right][1];

                left++;
                right++;
            }
            else if (nums1[left][0] < nums2[right][0]) {
                ans[k][0] = nums1[left][0];
                ans[k][1] = nums1[left][1];

                left++;
            }
            else {
                ans[k][0] = nums2[right][0];
                ans[k][1] = nums2[right][1];

                right++;
            }

            k++;
        }

        while (left < m) {
            ans[k][0] = nums1[left][0];
            ans[k][1] = nums1[left][1];

            left++;
            k++;
        }

        while (right < n) {
            ans[k][0] = nums2[right][0];
            ans[k][1] = nums2[right][1];

            right++;
            k++;
        }

        return Arrays.copyOf(ans, k);


    }
}