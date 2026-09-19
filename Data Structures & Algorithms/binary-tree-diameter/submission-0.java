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
    public int diameterOfBinaryTree(TreeNode root) {
        return depthAndDiameter(root)[1];
    }

    private int[] depthAndDiameter(TreeNode root){
        if(root == null){
            return new int[]{-1, 0};
        }
        var left = depthAndDiameter(root.left);
        var right = depthAndDiameter(root.right);
        int depth = Math.max(left[0]+1, right[0]+1);
        int maxDiameter = Math.max(Math.max(left[1], right[1]), left[0]+1 + right[0]+1);
        return new int[]{depth, maxDiameter};
    }
}
