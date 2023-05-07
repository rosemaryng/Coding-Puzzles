def levelOrderIterate(self, root: Optional[TreeNode]) -> list[list[int]]:
    res = []
    if not root:
        return res
    nodes = deque([root])
    while len(nodes):
        level_size = len(nodes)
        curr_level = []
        for i in range(level_size):
            node = nodes.popleft()
            curr_level.append(node.val)
            if node.left:
                nodes.append(node.left)
            if node.right:
                nodes.append(node.right)
        res.append(curr_level)
    return res

def levelOrderRecurse(self, root: Optional[TreeNode]) -> list[list[int]]:
        res = []
        if not root:
            return res
        nodes = deque([root])
        def bfs(root: Optional[TreeNode], curr_level: int)-> Optional[int]:
            if root:
                if curr_level >= len(res):
                    res.append([]) # create a new [] for a new level
                res[curr_level].append(root.val)
                if root.left:
                    bfs(root.left, curr_level + 1)
                if root.right:
                    bfs(root.right, curr_level + 1)
        bfs(root, 0)
        return res
