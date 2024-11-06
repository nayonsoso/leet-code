/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<TreeNode> children = getChildren(root);
        invertSubtree(root);
        while(!children.isEmpty()) {
            List<TreeNode> grandChildren = new LinkedList<>();
            for(TreeNode node : children) {
                invertSubtree(node);
                grandChildren.addAll(getChildren(node));
            }
            children = grandChildren;
        }

        return root;
    }

    void invertSubtree(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    List<TreeNode> getChildren(TreeNode root) {
        List<TreeNode> children = new LinkedList<>();
        if(root.left != null) {
            children.add(root.left);
        }
        if(root.right != null) {
            children.add(root.right);
        }
        return children;
    }
}
