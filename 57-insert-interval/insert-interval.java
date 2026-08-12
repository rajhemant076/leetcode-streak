class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
            i++;
        }
        int start=newInterval[0];
        int last=newInterval[1];
        while(i<n && intervals[i][0]<=last){
            start=Math.min(start,intervals[i][0]);
            last=Math.max(last,intervals[i][1]);
            i++;

        }
                    list.add(new ArrayList<>(Arrays.asList(start,last)));
                    while(i<n){
                        list.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
                        i++;
                    }
                    int ans[][]=new int[list.size()][2];
                    for(int j=0;j<list.size();j++){
                        ans[j][0]=list.get(j).get(0);
                        ans[j][1]=list.get(j).get(1);

                    }
                    return ans;



    }
}