class Solution {
    public int makeConnected(int n, int[][] connections) {
        boolean visited[]=new boolean[n];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int i=0;i<connections.length;i++){
            list.get(connections[i][0]).add(connections[i][1]);
            list.get(connections[i][1]).add(connections[i][0]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(list,i,visited);
                count++;
            }
        }
        int need=count-1;
        int extra=connections.length-(n-count);
        if(need>extra)return -1;
        return need;
    }
    public void dfs(ArrayList<ArrayList<Integer>> list,int curr,boolean visited[]){
        visited[curr]=true;
        for(int i=0;i<list.get(curr).size();i++){
            if(!visited[list.get(curr).get(i)]){
                dfs(list,list.get(curr).get(i),visited);
            }
        }
    }
}