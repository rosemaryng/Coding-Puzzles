# def maxScore(self, cards: List[int], k: int) -> int:
# solution: get the largest permutation
cards = [1,2,3,4,5,6,1]
k = 3
# points = 0
# for i in range(k + 1): # i means the number of the left most integer we take
#   right = i
#   left = k - right
#   curr_points = 0
#   curr_list = []
#   for j in range(left):
#       curr_points += cards[j]
#       curr_list.append(cards[j])
#       print(curr_list)
#     #   print(curr_points)
#   if (right > 0):
#       for j in range(1, right + 1):
#           print('j: ', j)
#           curr_points += cards[-j]
#           curr_list.append(cards[-j])
#           print(curr_list)
#         #   print(curr_points)

#   print('i: ', i, ' p: ', curr_points)
#   points = max(points, curr_points)

# print(points) 

s = sum(cards[:k])
res = s
for i in range(1, k+1):
    s += cards[-i] - cards[k-i]
    res = max(res, s)
# return res