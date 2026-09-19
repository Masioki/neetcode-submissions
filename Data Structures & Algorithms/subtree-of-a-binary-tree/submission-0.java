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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        for(var n : find(root, subRoot.val)){
            if(compare(n, subRoot)) {
                return true;
            }
        }
        return false;
    }


    private List<TreeNode> find(TreeNode root, int val){
        if(root == null){
            return List.of();
        }
        var left = find(root.left, val);
        var right = find(root.right, val);
        List<TreeNode> result = new LinkedList<>();
        result.addAll(left);
        result.addAll(right);
        if(root.val == val){
            result.add(root);
        }
        return result;
    }

    private boolean compare(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && compare(root1.left, root2.left) && compare(root1.right, root2.right);
    }
}
