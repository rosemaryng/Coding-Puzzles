package BinaryTrees;

public class BasicOperations {
  public boolean isValidBST(TreeNode root) {
    return isBST_MinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBST_MinMax(TreeNode subtree, int min, int max) {
    /* an empty tree is BST */
    if (subtree == null) return true;
    /* false if this node violates the min/max constraints */
    if (subtree.val <= min || subtree.val >= max) return false;
    return (isBST_MinMax(subtree.left, min, subtree.val - 1) &&
            isBST_MinMax(subtree.right, subtree.val + 1, max));

  }

  private boolean isBST_inOrder(TreeNode subtree, TreeNode prev) {
    if (subtree != null) {
      if (!isBST_inOrder(subtree.left, prev)) {
        return false;
      }
      if (subtree.left != null) {
        prev = subtree.left;
      }
      if (prev != null && prev.val >= subtree.val) {
        return false;
      }
      return isBST_inOrder(subtree.right, subtree);
    }
    return true;
  }
}
