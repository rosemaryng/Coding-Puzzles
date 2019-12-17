package BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class BuildTrees {
  int[] inorder;
  int[] postorder;
  Map<Integer, Integer> mapInorder = new HashMap<>();
  int postOrderRootInd;


  public TreeNode buildTree() {
    int length = postorder.length;
    if (length == 0) return null;
    postOrderRootInd = length - 1;
    for (int i = 0; i < length ; i++) mapInorder.put(inorder[i], i);
    return constructHelper(0, postOrderRootInd);
  }

  private TreeNode constructHelper(int l, int r) {
    if (l > r) {
      return null;
    }
    int rootVal = postorder[postOrderRootInd];
    TreeNode root = new TreeNode(rootVal);

    int leftSubTreeInd = mapInorder.get(rootVal);
    postOrderRootInd--;
    root.right = constructHelper(leftSubTreeInd + 1, postOrderRootInd);
    root.left = constructHelper(l, leftSubTreeInd - 1 );
    return root;
  }


}
