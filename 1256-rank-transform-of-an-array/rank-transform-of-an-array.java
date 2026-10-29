class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int num:arr)set.add(num);
        int rank=1;
        for(Integer i:set){
            map.put(i,rank++);
        }
        for(int i=0;i<n;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}