import heapq

def scheduleCourse(self, courses: List[List[int]]) -> int:
    s = []
    start = 0
    for t, end in sorted(courses, key=lambda c: c[1]):
        start += t
        heapq.heappush(s, -t)  # max heap
        if start > end:
            nt = heapq.heappop(s)  # the newly pushed t may also be poped
            start += nt  # nt is the negative t
    return len(s)