"""
Sort the array (O(nlong), O(1)) and then check if that number appears or some another greater number needs so be converted to it (JAVA Code)
Without using sort, just iterate the arr to get freq of all numbers appearing (maximum can become n, so greater than n--> treat as n){Counting sort(O(n), O(n))} -> Then same logic (PYTHON Code)
"""

class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        a=[0]*len(arr)
        for i in arr:
            if i>len(arr): i=len(arr)
            a[i-1]+=1
        ans=0
        for i in range(len(arr)):
            ans=min(ans+a[i],i+1)
        return ans