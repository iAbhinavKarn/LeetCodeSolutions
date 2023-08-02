class Solution:
    def isPalindrome(self, s: str) -> bool:
        copyString = ""
        for i in s:
            if (ord(i) >= 65 and ord(i) <= 90) or (ord(i) >= 97 and ord(i) <= 122) or (ord(i) >= 48 and ord(i) <= 57):
                if(ord(i) >= 65 and ord(i) <= 90):
                    copyString += chr(ord(i)+32)
                else:
                    copyString += chr(ord(i))
        isPalindrom = True
        for i in range(0, len(copyString)):
            if copyString[i] == copyString[len(copyString) -i -1]:
                continue
            else:
                return False
        return isPalindrom

sol = Solution()
sol.isPalindrome("A man, a plan, a canal: Panama")