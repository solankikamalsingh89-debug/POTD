""" Easy """
class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        h=0
        ans=0
        for i in gain:
            h+=i
            if h>ans: ans=h
        return ans