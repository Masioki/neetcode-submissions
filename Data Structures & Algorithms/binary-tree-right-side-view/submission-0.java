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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return List.of();
        }

        List<Integer> result = new LinkedList<>();
        result.add(root.val);
        var right = rightSideView(root.right);
        var left = rightSideView(root.left);
        for(int i = 0; i < right.size() || i < left.size(); i++){
            if(i < right.size()){
                result.add(right.get(i));
            } else {
                result.add(left.get(i));
            }
        }
        return result;
    }
}
