"""
{Similar to Kadane's Algorithm(To find maximum subarray sum) - Dyanamic Programming}
With iteration keep track of 2(Maxmimum till index with and without skipping till now).
Each time update answer as it can reduce as well

TC - O(n), SC - O(1)
"""

class Solution:
    def maxSumSubarray(self, arr):
        maxAtIdxNoSkip=arr[0]
        maxAtIdxSkip=arr[0]
        ans=arr[0]
        for i in range(1,len(arr)):
            maxAtIdxSkip=max(maxAtIdxNoSkip,maxAtIdxSkip+arr[i])
            maxAtIdxNoSkip=max(arr[i],maxAtIdxNoSkip+arr[i])
            ans=max(ans,maxAtIdxNoSkip,maxAtIdxSkip)
        return ans