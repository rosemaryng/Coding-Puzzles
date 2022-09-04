from ast import List
from typing import Dict

# def criticalConnections(n: int, connections: List[List[int]]) -> List[List[int]]:
n = 4
connections = [[0,1],[1,2],[2,0],[1,3]]

def criticalConnections(self, n, connections):
    # graph construction
    graph = [[] for i in range(n)]
    for u, v in connections:
        graph[u].append(v)
        graph[v].append(u)
    
    # depth initialization
    depths = [-1] * n
    results = []
    
    """
    visit every node exactly once, the starting point does not matter
    (as long as graph is connected)
    """
    def dfs(prev_node, cur_node, cur_depth):
        depths[cur_node] = cur_depth
        min_depth = cur_depth
        for neighbor in graph[cur_node]:
            if neighbor == prev_node: continue
            """
            find the temporary depth reached by a neighbor
            """
            temp_depth = depths[neighbor]
            """
            if the node is unexplored,  assign it's depth to current depth + 1
            """
            if temp_depth == -1:
                temp_depth = dfs(cur_node, neighbor, cur_depth+1)
            """
            if the returned depth is deeper than the "current depth", then it is a critical connection
            else, update the min_depth
            NOTE: we are comparing the "returned depth from neighbor (temp_dpeth)" to the "current depth reached by DFS" rather than the "min_depth" that is going to be returned.
                because once the temp_depth is returned by a neighbor, it is the minimum depth of it. 
            """
            if temp_depth > cur_depth:
                results.append([cur_node, neighbor])
            else:
                min_depth = min(min_depth, temp_depth)
        """
        return the minimum depth reached by a node
        """
        depths[cur_node] = min_depth
        return min_depth
    
    # start at node-0
    dfs(None, 0, 0)

        
# set = {}
# connections.sort()
# print(connections)
# pointer = connections[0][0]
# print(pointer)
# while pointer < len(connections):



# ans = []
# for [i,j] in connections:
#     dict[i] = dict.setdefault(i, 0) + 1
#     dict[j] = dict.setdefault(j, 0) + 1
#     print(dict)
# for [i, j] in connections:
#     if dict[i] == 1 or dict[j] == 1:
#         ans.append([i, j])
#     k = min(i, j)
#     v = max(i, j)
#     if k in dict:
#         new = dict.get(k)
#         new.append(v)
#     else:
#         dict[k] = [v]
#     print(dict)

# set = {}
# for dict.items:


# print(ans)
