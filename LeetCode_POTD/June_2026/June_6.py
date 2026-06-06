"""
Computed sum of all elements (in ls)       (Left Sum)
Changing value itself in nums with maintaing left sum(ls) and right sum(rs)
TC- O(n), SC- O(1)

(Even if we take array for output seperately- space will be occupied same as output and input storage is not counted)
"""

class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        ls=0
        rs=sum(nums)
        arr=[]
        for cur in nums:
            rs-=cur
            arr.append(abs(ls-rs))
            ls+=cur
        return arr