class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        boolean visited[]=new boolean[numCourses];
        boolean stack[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(isCycle(i,list,visited,stack))return false;
            }
        }
        return true;

    }
    public boolean isCycle(int curr,ArrayList<ArrayList<Integer>> list,boolean[] visited,boolean[] stack){
        visited[curr]=true;
        stack[curr]=true;
        for(int i=0;i<list.get(curr).size();i++){
            if(stack[list.get(curr).get(i)])return true;
            if(!visited[list.get(curr).get(i)]){
                if(isCycle(list.get(curr).get(i),list,visited,stack))return true;
            }
        }
        stack[curr]=false;
        return false;

    }
}