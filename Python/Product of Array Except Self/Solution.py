from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        max = 1
        secondMax = 1
        zeroCount = 0
        for i in nums:
            if(i == 0):
                max = 0
                zeroCount += 1
                secondMax *= 1
            
            else:
                max *= i;
                secondMax *= i;
        returnList = []
        for i in nums:
            if(i == 0):
                if zeroCount > 1:
                    returnList.append(0)
                else:
                    returnList.append(secondMax)
            else:
                returnList.append(int(max/i))
        return returnList

sol = Solution()
sol.productExceptSelf([4,1,-1,2,-1,2,3])