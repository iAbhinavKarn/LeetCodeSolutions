from typing import List

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        returnList = []
        for i in range(0, len(numbers)):
            valueToFind = target - numbers[i]
            numbers[i] = 1001
            if valueToFind in numbers:
                index = numbers.index(valueToFind)
                if(index > i):
                    returnList.append(i+1)
                    returnList.append(index + 1)
                    return returnList

sol = Solution()
sol.twoSum([2,7,11,15], 9)