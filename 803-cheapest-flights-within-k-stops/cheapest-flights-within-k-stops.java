class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            list.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        int dis[][]=new int[n][k+2];
        for(int i=0;i<n;i++)Arrays.fill(dis[i],Integer.MAX_VALUE);
        dis[src][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int node=curr[1];
            int dist=curr[0];
            int step=curr[2];

            if(node==dst)return dist;
            if(step>k)continue;
            for(int i=0;i<list.get(node).size();i++){
                int neigh[]=list.get(node).get(i);
                if(dis[neigh[0]][step+1]>dist+neigh[1]){
                    dis[neigh[0]][step+1]=dist+neigh[1];

                
                pq.add(new int[]{dist+neigh[1],neigh[0],step+1});
                }
            }
        }
        return -1;

    }
}