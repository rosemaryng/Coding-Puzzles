package BinaryTrees;

public class CountUniValue {
  int count = 0;
  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) return count;
    isUniVal(root);
    return count;
  }

  private boolean isUniVal(TreeNode root) {
    if (root.left == null && root.right == null) {
      count++;
      return true;
    }
    Boolean isUniVal = true;
    if (root.left != null) {
      isUniVal = isUniVal(root.left) && root.left.val == root.val;
    }
    if (root.right != null) {
      isUniVal &= isUniVal(root.right) && root.right.val == root.val;
    }
    count += isUniVal ? 1 : 0;
    return isUniVal;
  }

}
