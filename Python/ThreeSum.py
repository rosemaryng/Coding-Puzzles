class ThreeSum:
    # brute force!
    def twoSum_1(self, nums: List[int], target: int) -> List[int]:
        curr_sum = target
        nums_len = len(nums)
        for i, num in enumerate(nums):
            curr_sum = target - num
            for j in range(i + 1, nums_len):
                if curr_sum - nums[j] == 0:
                    return [i,j]

    # O(n) Time, O(n) Space
    def twoSum_2(self, nums: List[int], target: int) -> List[int]:
        appeared_nums = {}
        for i, num in enumerate(nums):
            required_target = target - num
            if required_target in appeared_nums:
                return [appeared_nums[required_target], i]
            appeared_nums[num] = i

    def twoSum_II(self, numbers: List[int], target: int) -> List[int]:
        res = []
        start = 0
        end = len(numbers) - 1
        while end > start:
            required_num = target - numbers[end]
            if numbers[start] == required_num:
                return [start + 1, end + 1]
            elif numbers[start] < required_num:
                start += 1
            else:
                end -= 1
        return res


    
