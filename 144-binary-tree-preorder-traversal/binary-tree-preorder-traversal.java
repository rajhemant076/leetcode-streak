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
    public List<Integer> preorderTraversal(TreeNode root) {
        return helper(root);
    }
    public List<Integer> helper(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null)return list;
        list.add(root.val);
        list.addAll(helper(root.left));
        list.addAll(helper(root.right));
        return list;
    }
}