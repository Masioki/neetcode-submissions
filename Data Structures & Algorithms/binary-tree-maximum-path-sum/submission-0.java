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
 public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    var res = maxPath(root);
    return Math.max(res[0], res[1]);
  }

  /**
   * 0 - can extend
   * 1 - cannot extend
   */
  private int[] maxPath(TreeNode root) {
    int currentVal = root.val;
    int[] leftRes = null;
    int[] rightRes = null;
    if (root.left != null) {
      leftRes = maxPath(root.left);
    }
    if (root.right != null) {
      rightRes = maxPath(root.right);
    }


    int res0 = currentVal;
    int res1 = currentVal;
    if (leftRes != null && rightRes != null) {
      res1 = Math.max(res1, leftRes[0] + rightRes[0] + currentVal);
    }
    if (leftRes != null) {
      res0 = Math.max(res0, leftRes[0] + currentVal);
      res1 = Math.max(res1, Math.max(leftRes[0], leftRes[1]));
    }
    if (rightRes != null) {
      res0 = Math.max(res0, rightRes[0] + currentVal);
      res1 = Math.max(res1, Math.max(rightRes[0], rightRes[1]));
    }
    return new int[] {res0, res1};
  }
}
