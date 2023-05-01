def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        cols = len(mat[0])
        dist = [[float('inf') for _ in range(cols)] for _ in range(rows)]
        q = deque()

        # Initialize the queue and distances for cells that contain 0
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    q.append((r, c))
                    dist[r][c] = 0

        # Perform BFS starting from cells that contain 0
        while q:
            (r, c) = q.popleft()
            for nr, nc in [(r-1, c), (r+1, c), (r, c-1), (r, c+1)]:
                if 0 <= nr < rows and 0 <= nc < cols:
                    new_dist = dist[r][c] + 1
                    if new_dist < dist[nr][nc]:
                        dist[nr][nc] = new_dist
                        q.append((nr, nc))

        return dist

# O(m*n) for space and time

def updateMatrix2(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        cols = len(mat[0])
        res = [[float('inf') for _ in range(cols)] for _ in range(rows)]

        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    res[i][j] = 0
                else:
                    if i > 0: # check column up
                        res[i][j] = min(res[i][j], res[i - 1][j] + 1)
                    if j > 0: # check column left
                        res[i][j] = min(res[i][j], res[i][j - 1] + 1)
        print(res)
        for i in range(rows - 1, -1, -1):
            for j in range (cols - 1, -1, -1):
                # print(i, ' ', j)
                if (i < rows - 1): # check down
                    res[i][j] = min(res[i][j], res[i + 1][j] + 1)
                if (j < cols - 1):
                    res[i][j] = min(res[i][j], res[i][j + 1] + 1)
        return res

# O(m*n) for time O(1) space
