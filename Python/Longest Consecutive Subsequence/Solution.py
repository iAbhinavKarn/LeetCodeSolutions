from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        max = 1
        nums.sort()
        previous = nums[0]
        returnInt = max
        for i in range(1,len(nums)):
            if previous == nums[i]:
                continue
            if previous + 1 == nums[i]:
                max += 1
                previous = nums[i]
            else:
                previous = nums[i]
                if(max > returnInt):
                    returnInt = max
                max = 1
        if max > returnInt:
            returnInt = max
        return returnInt

sol = Solution()
sol.longestConsecutive([0,3,7,2,5,8,4,6,0,1])