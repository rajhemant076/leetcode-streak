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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> list=new ArrayList<>();
        boolean reverse=false;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                temp.add(curr.val);

                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);

                
            }
            if(reverse){
                Collections.reverse(temp);
            }
            reverse=!reverse;
            list.add(temp);
            
        }
        return list;
        
    }
}