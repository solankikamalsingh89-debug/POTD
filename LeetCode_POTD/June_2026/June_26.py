"""
Treating target as 1 and all others as -1.
Find the prefix sum array according to it and find ways so that sum is greater than 0. --> It will lead to O(n^2){Sum -n to n}
So, we will mark number of times that lesser than idx, prefix sum came till iterated and increase the result accordingly.{prefix[r]>prefix[l] for (l to r) to be counted }
freq -> thought as represents sum --> -n, -n+1, ... 0 ... n-1, n  and pref represents freq of all less than x occuring

TC - O(n), SC - O(n)
"""

class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        n=len(nums)
        preSum=[0]*(2*n+1)
        #Treat n as cur
        preSum[n]=1
        pref=0
        res=0
        for x in nums:
            if x==target:
                pref+=preSum[n]
                n+=1
            else:
                n-=1
                pref-=preSum[n]
            res+=pref
            preSum[n]+=1
        return res