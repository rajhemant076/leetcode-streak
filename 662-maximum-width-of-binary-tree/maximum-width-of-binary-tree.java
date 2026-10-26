/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int minIndex=q.peek().index;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                Pair curr=q.remove();
                int currIndex=curr.index-minIndex;
                TreeNode node=curr.node;
                if(i==0)first=currIndex;
                if(i==size-1)last=currIndex;
                if(node.left!=null){
                    q.add(new Pair(node.left,2*currIndex+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,2*currIndex+2));
                }

            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
        
    }
}