# 'aabc' -> 'a - 2, b - 1, c - 1'

from collections import defaultdict

def dictafyString(chars: str) -> str:

    # 1st way:

    # res_dict = {}
    # for char in chars:
    #     if char in res_dict:
    #         res_dict[char] += 1
    #     else:
    #         res_dict[char] = 1

    # 2nd way:
    # res_dict = {}
    # for char in chars:
    #     res_dict[char] = res_dict.get(char, 0)

    # 3rd way:
    res_dict = defaultdict(int)
    for char in chars:
        res_dict[char] += 1

    # res = ""
    # for char, count in res_dict.items():
    #     if len(res) > 0:
    #         res += ', '
    #     res += f"{char} - {count}"

    res = []
    for char, count in res_dict.items():
        # if len(res) > 0:
        #     res.append(', ')
        res.append(f"{char} - {count}")

    return ", ".join(res)


def uniqueNumsAscending(nums: List[int]) -> List[int]:
    unique_set = set()
    for num in nums:
        unique_set.add(num)

    return sorted(list(unique_set))
