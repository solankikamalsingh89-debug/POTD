"""
For every value in arr, checked with binary search itself to check if could be found
TC - O(nlogn), SC - O(1)
"""
class Solution:
    def binarySearchable(self, arr):
        ans=0
        for i in arr:
            l=0
            r=len(arr)-1
            while l<=r:
                m=(l+r)>>1
                if arr[m]==i:
                    ans+=1
                    break
                elif arr[m]>i:
                    r=m-1
                else:
                    l=m+1
        return ans