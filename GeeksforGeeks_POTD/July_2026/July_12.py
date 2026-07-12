"""
Use priority queue too get maximum element each time either untill tickets exhaust or limit of k exceed

TC - O(n+klogn), SC - O(n)
"""

class Solution:
    def maxAmount(self, arr, k):
        minHeap =[]
        for i in arr: heapq.heappush(minHeap,-i)
        amt=0
        while k>0 and minHeap:
            a=-heapq.heappop(minHeap)
            amt=(amt+a)%1000000007
            if a>1: heapq.heappush(minHeap,1-a)
            k-=1
        return amt