"""
Divide in groups (partiotion from point where differnce in neighbours is more than maxDiff)
If queries point in same group return yes.

TC - O(n+m), SC - O(n)
"""

class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        a=[]
        grp=1
        a.append(1)
        for i in range(n-1):
            if nums[i+1]-nums[i]>maxDiff: grp+=1
            a.append(grp)
        ans=[]
        for u,v in queries:
            if(a[u]==a[v]): ans.append(True)
            else: ans.append(False)
        return ans