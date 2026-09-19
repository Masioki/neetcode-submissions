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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int p, int q){
        if(p > q){
            int temp = p;
            p = q;
            q = temp;
        }
        int val = root.val;
        if(p <= val && q >= val){
            return root;
        }
        if(p < val){
            return find(root.left, p, q);
        }
        return find(root.right, p, q);
    }
}
