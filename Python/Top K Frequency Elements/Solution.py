from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if len(nums) == k:
            return nums
        hashMapDict = {}
        for num in nums:
            if num not in hashMapDict:
                hashMapDict[num] = 0
            hashMapDict[num] = hashMapDict.get(num) + 1
        valuesList = list(hashMapDict.values())
        keyList = list(hashMapDict.keys())
        copyValueList = valuesList
        valuesList.sort()
        valuesList.reverse()
        returnList = []
        value = 0
        previousKey = ""
        for i in range(0, k):
            if previousKey != "":
                hashMapDict.pop(previousKey)
            for key,value in hashMapDict.items():
                if value == valuesList[i]:
                    returnList.append(key)
                    previousKey = key
                    break
        return returnList

sol = Solution()
sol.topKFrequent([4,1,-1,2,-1,2,3], 2)
            