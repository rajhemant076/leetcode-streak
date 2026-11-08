class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<=n;i++)list.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            list.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        boolean visited[]=new boolean[n+1];
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int node=curr[0];
            int d=curr[1];

            if(!visited[node]){
                visited[node]=true;
                for(int i=0;i<list.get(node).size();i++){
                    int neigh[]=list.get(node).get(i);
                    if(dist[neigh[0]]>dist[node]+neigh[1]){
                        dist[neigh[0]]=dist[node]+neigh[1];
                        pq.add(new int[]{neigh[0],dist[neigh[0]]});
                    }
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            ans=Math.max(ans,dist[i]);

        }
        return ans;
    }
}