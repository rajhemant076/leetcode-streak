class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        int max=0;
        int count=0;
        for(int f:freq)max=Math.max(max,f);
        for(int f:freq){
            if(f==max)count++;
        }
        return Math.max(tasks.length,(max-1)*(n+1)+count);
    }
}