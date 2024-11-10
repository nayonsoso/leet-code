class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return recur(root, true);
    }

    static int calculateHeight(TreeNode root, int height) {
        if (root == null) {
            return height;
        }

        return Math.max(calculateHeight(root.left, height + 1), calculateHeight(root.right, height + 1));
    }

    static int countNodes(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + countNodes(root.right);
        }
        if (root.right == null) {
            return 1 + countNodes(root.left);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static boolean recur(TreeNode root, boolean result) {
        if(root == null || !result) {
        return result;
        }

        int left = root.left == null ? 0 : calculateHeight(root.left, 0);
        int right = root.right == null ? 0 : calculateHeight(root.right, 0);

        boolean newResult = (Math.abs(left - right) <= 1);
        return recur(root.left, newResult) && recur(root.right, newResult);
  }
}
