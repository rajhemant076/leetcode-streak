class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dist[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;
        int d[][]={{1,0},{0,1},{-1,0},{0,-1}};

        while(!pq.isEmpty()){
            int curr[]=pq.remove();
            int effort=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==m-1 && c==n-1)return effort;
            for(int dx[]:d){
                int nr=r+dx[0];
                int nc=c+dx[1];
                if(nr<0 || nr>=m || nc<0 || nc>=n)continue;
                int newEffort=Math.max(effort,Math.abs(heights[nr][nc]-heights[r][c]));
                if(dist[nr][nc]>newEffort){
                    dist[nr][nc]=newEffort;
                    pq.add(new int[]{newEffort,nr,nc});
                }
            }

        }
        return 0;

    }
}