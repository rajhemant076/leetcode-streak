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
    int index=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        reverse(postorder);
        return helper(postorder,inorder,0,inorder.length-1);
    }
     public TreeNode helper(int postorder[],int inorder[],int s,int e){
        if(s>e)return null;
        int rootVal=postorder[index++];
        TreeNode root=new TreeNode(rootVal);
        int mid=findRootIndex(rootVal,inorder,s,e);
        root.right=helper(postorder,inorder,mid+1,e);
        root.left=helper(postorder,inorder,s,mid-1);
        

        return root;
    }
    public int findRootIndex(int val,int[] inorder,int s,int e){
        for(int i=s;i<=e;i++){
            if(inorder[i]==val)return i;
        }
        return -1;
    }
    public void reverse(int[]  arr){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}