# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class CloneGraph:
def cloneGraph(self, node: 'Node') -> 'Node':
    if not node:
        return node
    # map of {val, copied_node}
    initialised = {}
    initialised[node.val] = Node(node.val, None)
    # a queue of nodes to visit (of the original node) - using DFS
    to_visit = collections.deque()
    to_visit.append(node)

    while to_visit:
        curr_node = to_visit.pop()
        # if we have not initialised neighbours before:
        if curr_node.val in initialised and curr_node.neighbors and not initialised[curr_node.val].neighbors:
            new_node = initialised[curr_node.val]
            new_neighbors = []

            for neighbor in curr_node.neighbors:
                if neighbor.val not in initialised:
                    to_visit.append(neighbor)
                    neighbor_node = Node(neighbor.val, None)
                    initialised[neighbor.val] = neighbor_node
                else:
                    neighbor_node = initialised[neighbor.val]

                new_neighbors.append(neighbor_node)

            new_node.neighbors = new_neighbors
            initialised[curr_node.val] = new_node
            print(f"new_neighbors: {[e.val for e in new_node.neighbors]}")
            print(f"initialised: {initialised.keys()}")
    return initialised[node.val]

    def cloneGraph(self, node: 'Node') -> 'Node':
        # map of {initial_node, copied_node}
        cloned = {}
        def clone_node(node: 'Node') -> 'Node':
            cloned_neighbors = None
            if node in cloned:
                return cloned[node]
            else:
                new_node = Node(node.val)
                cloned[node] = new_node
                for n in node.neighbors:
                    cloned[node].neighbors.append(clone_node(n))
                return new_node

        return clone_node(node) if node else node
