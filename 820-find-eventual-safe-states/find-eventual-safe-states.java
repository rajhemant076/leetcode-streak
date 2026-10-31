class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean safe[]=new boolean[n];
        int out[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                out[i]++;
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());

        for(int i=0;i<n;i++){
        for(int j=0;j<graph[i].length;j++){
            list.get(graph[i][j]).add(i);
        }
        }
        Queue<Integer> q=new LinkedList<>();

        // boolean safe[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(out[i]==0)q.add(i);

        }
        while(!q.isEmpty()){
            int curr=q.poll();
            safe[curr]=true;
            for(int i=0;i<list.get(curr).size();i++){
                out[list.get(curr).get(i)]--;
                if(out[list.get(curr).get(i)]==0)q.add(list.get(curr).get(i));
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){ 
        if(safe[i]){
            ans.add(i);
        }
        }
        return ans;

    }
}