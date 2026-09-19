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
   public TreeNode buildTree(int[] preorder, int[] inorder) {
    // preorder  root left right
    // inorder left root right
    // postorder left right root
    return build(preorder, inorder, 0, 0, inorder.length - 1);
  }

  public TreeNode build(int[] preorder, int[] inorder, int preorderFrom, int inorderFrom, int inorderTo) {
    // preorder  root left right
    // inorder left root right
    // postorder left right root
    if(preorderFrom >= preorder.length || inorderFrom >= inorder.length || inorderTo < 0 || inorderFrom > inorderTo){
      return null;
    }

    int rootValue = preorder[preorderFrom];
    int indexOfRoot = -1;
    for(int i = inorderFrom; i <= inorderTo; i++){
      if (rootValue == inorder[i]) {
        indexOfRoot = i;
        break;
      }
    }
    int leftSideCount = indexOfRoot - inorderFrom;
    TreeNode leftNode = build(preorder, inorder, preorderFrom + 1, inorderFrom, indexOfRoot - 1);
    TreeNode rightNode = build(preorder, inorder,  preorderFrom + leftSideCount + 1, indexOfRoot + 1, inorderTo);
    return new TreeNode(rootValue, leftNode, rightNode);
  }
}
