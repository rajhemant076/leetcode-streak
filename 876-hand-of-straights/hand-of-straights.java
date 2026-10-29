class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);

        }
        for(int e:hand){
            if(map.get(e)==0)continue;
            for(int i=0;i<groupSize;i++){
                if(map.getOrDefault(e+i,0)==0)return false;
                map.put(e+i,map.get(e+i)-1);
            }
            
        }
        return true;
    }
}