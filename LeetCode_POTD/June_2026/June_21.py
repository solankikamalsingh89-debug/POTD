"""
New Method: Counting Sort(For all numbers as index of another array, store frequenccy for them)

Applied Counting Sort, then handle coins left to know how much can we buy from lowest to going higher indices.
(However, we could do it by making array with max value- by adding one traversal in array first to get maximum value)

TC - O(10^5+n)=O(1), SC - O(10^5)=O(1)
"""
class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        a=[0]*100001
        l=0
        for i in costs: a[i]+=1
        for i in range (1,100001):
            coins-=(i*a[i])
            if coins>=0: l+=a[i]
            else:
                l+=(coins+(i*a[i]))//i
                break
        return l