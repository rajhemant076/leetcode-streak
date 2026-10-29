class Solution {
    static class Node{
        Node children[]=new Node[2];
    }
    Node root=new Node();

    void insert(int num){
        Node curr=root;
        for(int i=30;i>=0;i--){
            int bit=(num>>i) & 1;
            if(curr.children[bit]==null)curr.children[bit]=new Node();
            curr=curr.children[bit];
        }
    }
    public int findXor(int num){
        Node curr=root;
        int xor=0;
        for(int i=30;i>=0;i--){
            int bit=(num>>i) &1;
            int opposite=1-bit;
            if(curr.children[opposite]!=null){
                xor|=(1<<i);
                curr=curr.children[opposite];

            }
            else curr=curr.children[bit];
        }
        return xor;
    }
    public int findMaximumXOR(int[] nums) {
        for(int num:nums){
            insert(num);
        }
        int maxXor=0;
        for(int num:nums){
            maxXor=Math.max(maxXor,findXor(num));

        }
        return maxXor;
    }
}