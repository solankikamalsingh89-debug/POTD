"""
Just check each alphabet last and first occurence and spot max gap

TC - O(n), SC - O(1)
"""

class Solution:
    def maxCharGap(self, s: str) -> int:
        f=[]
        ans=-1
        for i in range(97, 123):
            f.append(s.find(chr(i)))
        for i in range(97, 123): ans=max(ans,s.rfind(chr(i))-f[i-97]-1)
        return ans