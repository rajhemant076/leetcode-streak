
class Solution {
    public int countPaths(int n, int[][] roads) {

        int mod = 1000000007;

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for(int i = 0; i < roads.length; i++) {
            list.get(roads[i][0]).add(
                new int[]{roads[i][1], roads[i][2]}
            );

            list.get(roads[i][1]).add(
                new int[]{roads[i][0], roads[i][2]}
            );
        }

        long dist[] = new long[n];
        long ways[] = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        pq.add(new long[]{0, 0});

        while(!pq.isEmpty()) {

            long curr[] = pq.poll();

            long d = curr[0];
            int node = (int)curr[1];

            if(d > dist[node]) continue;

            for(int i = 0; i < list.get(node).size(); i++) {

                int neigh[] = list.get(node).get(i);

                long newDist = d + neigh[1];

                // Shorter path found
                if(newDist < dist[neigh[0]]) {

                    dist[neigh[0]] = newDist;

                    ways[neigh[0]] = ways[node];

                    pq.add(new long[]{
                        newDist, neigh[0]
                    });
                }

                // Another shortest path found
                else if(newDist == dist[neigh[0]]) {

                    ways[neigh[0]] =
                        (ways[neigh[0]] + ways[node]) % mod;
                }
            }
        }

        return (int)(ways[n-1] % mod);
    }
}
