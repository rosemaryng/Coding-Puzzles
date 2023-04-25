# l = [1, 2, 3]
# print(l[0])
# print(l[-1])
# print(l[-2])
# print(l[-0])
# print(l[1:])
# print(l[:3])

d = {'a': 3, 'b': 3, 'c': 2}

# for key in d:
#     print(key)

for k,v in d.items():
    print(k, v)

from typing import List, Set

nums = [12, 12, 4, 5, 7, 2, 1]

# Square all numbers using map

squared = list(map(lambda x: x * x, nums))

print('squared: ', squared)

power_6 = list(map(lambda x: x ** 6, nums))
print(power_6)


# Print all numbers that are divisible by 3 -> [12, 12]
print([x for x in nums if x % 3 == 0])


print(list(filter(lambda x: x % 3 == 0, nums)))


def filterOutTerrorists(names: List[str], terrorists: Set[str]) -> List[str]:
    return list(filter(lambda name: name not in terrorists, names))
