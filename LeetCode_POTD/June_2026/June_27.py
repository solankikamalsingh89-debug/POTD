"""
We first sorted array in ascending order
Then traverse in increasing order to keep check tiil this number maximumLength with help of storing length with numbers appeared in dictionary(It also helped in checking if sqrt appeared or not)
Also special check on 1 in starting as its sqrt is not less than itself

TC - O(nlogn), SC - O(n)
"""

class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        nums.sort()
        f2={}
        i=0
        while i<len(nums) and nums[i]==1 : i+=1
        m=max(1,i-1 if i&1==0 else i)
        while i<len(nums):
            j=math.sqrt(nums[i])
            if j in f2:
                if i+1<len(nums) and nums[i]==nums[i+1]:
                    f2[nums[i]]=f2[j]+2
                    while i+1<len(nums) and nums[i]==nums[i+1]: i+=1
                m=max(m,f2[j]+1)
            elif i+1<len(nums) and nums[i]==nums[i+1]:
                f2[nums[i]]=2
                while i+1<len(nums) and nums[i]==nums[i+1]: i+=1
            i+=1
        return m