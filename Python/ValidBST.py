def isValidBST(self, root: Optional[TreeNode]) -> bool:
    def validate(node, left, right):
        if not node:
            return True
        if not (node.val > left and node.val < right):
            return False
        return validate(node.left, left, node.val) and validate(node.right, node.val, right)

    return validate(root, -math.inf, math.inf)

def isValidBSTIterative(self, root: Optional[TreeNode]) -> bool:
    stack = [root]
    while root:
        # while root.left:
        #     root = root.left

        # root = stack.pop()
        if (root.left and root.left.val >= root.val) or (root.right and root.right.val <= root.val):
            return False
        
        if root.right:
            root = root.right
            stack.appent(root)
    return validate(root, -math.inf, math.inf)
"""
   5
1     7
     6 8
        9
"""

def isValidBSTInOrderIterative(self, root: Optional[TreeNode]) -> bool:
    node_stack = []
    prev = -math.inf
    ptr = root
    while node_stack or ptr:
        while ptr:
            node_stack.append(ptr)
            ptr = ptr.left
        ptr = node_stack.pop()
        if ptr.val <= prev:
            return False
        prev = ptr.val
        ptr = ptr.right
    return True



def isValidBSTRecursive(self, root: Optional[TreeNode]) -> bool:
    def traverse(node):
        if not node:
            return True
        if not traverse(node.left):
            return False
        if node.val <= self.prev:
            print(f"val: {node.val} prev: {self.prev}")
            return False
        self.prev= node.val
        return traverse(node.right)

    self.prev = -math.inf
    return traverse(root)
