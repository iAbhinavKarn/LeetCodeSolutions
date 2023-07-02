from typing import List


class Solution(object):
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        hashMapDict = {}
        for strValue in strs:
            # sorted(strValue) This gives value like eat = ['a', 'e', 't']
            sortedString = ''.join(sorted(strValue))
            if sortedString not in hashMapDict:
                hashMapDict[sortedString] = []
            hashMapDict[sortedString].append(strValue)
        return list(hashMapDict.values())

sol = Solution()
sol.groupAnagrams(["eat","tea","tan","ate","nat","bat"])

