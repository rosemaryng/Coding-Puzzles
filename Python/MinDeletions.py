# def minDeletions(self, s: str) -> int:
from collections import Counter


s = "aaabbbcc"
d = {}
for char in s:
    if char in d:
        d[char] = d.get(char) + 1
    else:
        d[char] = 1

# a = sorted(d.items(), key=lambda x: x[1], reverse=True)

a = dict(sorted(d.items(), key=lambda x: x[1], reverse=True))

print(a)
curr_frequency = 100000
counter = 0
# for (c, f) in a:
#     if f < curr_frequency:
#         curr_frequency = f
#     elif curr_frequency == 0:
#         counter = counter + f
#     else:
#         print('c: ', c)
#         new_f = f
#         while new_f >= curr_frequency:
#             counter = counter + 1
#             new_f = new_f - 1
            
#         curr_frequency = new_f

# method 2: update dictionary
last_item = None
for (c, f) in a.items():
    if f < curr_frequency:
        curr_frequency = f
        
    elif curr_frequency == 0:
        counter = counter + f
    else:
        curr_frequency = a[last_item] - 1
        counter = counter + (f - curr_frequency)
        a[c] = curr_frequency
    last_item = c

print('counter: ', counter)
    


