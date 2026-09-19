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
     public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        inorder(root, k, stack);
        return stack.pop();
    }

    private void inorder(TreeNode root, int k, Stack<Integer> stack){
        if(root == null || stack.size() >= k){
            return;
        }
        inorder(root.left, k, stack);
        if(stack.size() < k){
            stack.push(root.val);
        }
        inorder(root.right, k, stack);
    }
}
