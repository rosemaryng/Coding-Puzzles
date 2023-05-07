from typing import List
def productExceptSelf(nums: List[int]) -> List[int]:
    left_products = [1]
    right_products = [1]
    length = len(nums)
    for i in range(length - 1):
        left_products.append(left_products[-1] * nums[i])
        right_products.insert(0, right_products[0] * nums[length - 1 - i])


    for i in range(length - 1):
        left_products[i] = left_products[i] * right_products[i]

    return left_products


def productExceptSelfNoSpace(nums: List[int]) -> List[int]:
    # traversing from left to right -- getting left products
    res = [1]
    for i in range(len(nums) - 1):
        res.append(res[-1] * nums[i])

    # traversing from right to left -- getting right products
    right_sum = 1
    for i in range(len(nums) - 1, -1, -1): ## start, end (not inclusive), step size
        res[i] = res[i] * right_sum
        right_sum = right_sum * nums[i]

    return res

print(productExceptSelfNoSpace([1,2,3,4]))
# [1, 2, 3, 4]
# [1, 1, 2, 6]
# [24, 12, 4 ,1]
