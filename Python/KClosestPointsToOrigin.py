def kClosest(self, points: list[list[int]], k: int) -> list[list[int]]:
    distances = [] # always a list equal or under size 2
    for x, y in points:
        distance = math.sqrt(x * x + y * y)
        distances.append([distance, x, y])
    distances = sorted(distances, key=lambda item:item[0])
    coords =  [[x, y] for (_, x, y) in distances]
    return coords[:k]
