package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class AllTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    generateTreePath(res, root, "");
    return res;
  }

  private void generateTreePath(List<String> res, TreeNode root, String s) {
    if (root != null) {
      s += Integer.toString(root.val);

      if (root.left == null && root.right == null){
        res.add(s);
        return;
      }
      s += "->" ;
      generateTreePath(res, root.left, s);
      generateTreePath(res, root.right, s);
    }
  }
}
