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
    public boolean isBalanced(TreeNode root) {
        return getSubtreeHeight(root) != -1;
    }

    // depth of the two subtrees of every node never differs by more than one
    // compare subtree's height and return it's height or -1
    static int getSubtreeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = getSubtreeHeight(root.left);
        int rightHeight = getSubtreeHeight(root.right);

        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
