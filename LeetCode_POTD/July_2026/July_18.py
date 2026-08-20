"""
Easy- do as stated

TC - O(log(min)), SC - O(1)
"""

class Solution:
    def findGCD(self, nums: List[int]) -> int:
        m0, m1=min(nums),max(nums)
        while m0>0:
            m1,m0=m0,m1%m0
        return m1