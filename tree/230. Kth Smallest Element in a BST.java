/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }
     
    private void helper(TreeNode node) {
        if (node == null || count < 0) {
            return;
        }
        
        helper(node.left);
        count--;
        if (count == 0) {
            result = node.val;
        }
        helper(node.right);
    }
}
