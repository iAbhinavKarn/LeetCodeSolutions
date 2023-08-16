class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        returnValue = 0
        while(left < right):
            maxHeight = min(height[left], height[right]) * (right - left)
            returnValue = max(returnValue, maxHeight)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return returnValue