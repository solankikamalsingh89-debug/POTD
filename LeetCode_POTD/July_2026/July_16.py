"""
Just do as prescribed in question.

TC - O(nlogn), SC - O(1)
"""

class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        n=len(nums)
        prefixGCD=[]
        m=nums[0]
        for i in nums:
            if m<=i: 
                prefixGCD.append(i)
                m=i
            else:
                prefixGCD.append(math.gcd(i,m))
        prefixGCD.sort()
        ans=0
        for i in range(n//2):
            ans+=math.gcd(prefixGCD[n-i-1],prefixGCD[i])
        return ans