def lengthOfLongestSubstring(self, s: str) -> int:
    start = end = 0
    visited = {} # key: char, value: index
    longest = 0
    for i, char in enumerate(s):
        if char in visited and visited[char] >= start:
            start = visited[char] + 1
        visited[char] = i # update most recent appearance
        end += 1
        longest = max(longest, end - start)
    return longest
