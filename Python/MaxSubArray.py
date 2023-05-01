def maxSubArray(self, nums: List[int]) -> int:
    max_subarray = -math.inf
    for i in range(len(nums)):
        current_subarray = 0
        for j in range(i, len(nums)):
            current_subarray += nums[j]
            max_subarray = max(max_subarray, current_subarray)

    return max_subarray

def maxSubArray_Sliding(self, nums: List[int]) -> int:
    max_sum = curr_sum = nums[0]
    for num in nums[1:]:
        curr_sum = max(curr_sum + num, num)
        max_sum = max(max_sum, curr_sum)
    return max_sum

def maxSubArray_DivideConqueur(self, nums: List[int]) -> int:
