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
        Map<Integer, int[]> cache = new HashMap<>();
        fillCache(root, cache);
        return find(root, k, cache);
    }

    private int find(TreeNode root, int k, Map<Integer, int[]> cache){
        var entry = cache.get(root.val);
        int smaller = entry[0];
        if(smaller == k - 1){
            return root.val;
        }

        if(smaller >= k) {
            return find(root.left, k, cache);
        }
        return find(root.right, k - smaller - 1 , cache);
    }

    private int fillCache(TreeNode root, Map<Integer, int[]> cache){
        if(root == null){
            return 0;
        }
        int smaller = fillCache(root.left, cache);
        int bigger = fillCache(root.right, cache);
        cache.put(root.val, new int[]{smaller, bigger});
        return smaller + bigger + 1;
    }
}
