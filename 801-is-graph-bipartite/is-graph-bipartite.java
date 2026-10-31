class Solution {
    public boolean isBipartite(int[][] graph) {
        // boolean visited[]=new boolean[graph.length];
        int color[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)color[i]=-1;
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!dfs(graph,0,i,color))return false;
            }
        }
        return true;

    }
    public boolean dfs(int[][] graph,int c,int curr,int color[]){
        // visited[curr]=true;
        color[curr]=c;
        //  c=c==0?1:0;
        for(int i=0;i<graph[curr].length;i++){
            if(color[graph[curr][i]]==-1){
               
                if(!dfs(graph,1-c,graph[curr][i],color))return false;
                
            }
            else if(color[graph[curr][i]]==c)return false;
        }
        return true;
        


    }
}