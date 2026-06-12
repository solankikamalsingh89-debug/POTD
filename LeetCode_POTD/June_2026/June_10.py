"""
Precompute with O(nlogn) for finding min and max in any range of array
Store with PriorityQueue to store in descending order of value to extract till k>0(needed cases), each time decresing the length of subarray(starting with complete array)
TC - O(nlogn + klogn), SC - O(nlogn)

New Learning: SparseTable(Static Array, multiple cases to get max or min in different subarrays)
i)PreComputation( O(nlogn) )
    Let's assume dots(.) as elements of array      (Let's say 9 elements)
    . . . . . . . . .            (Level 0 - (i)th element represents subarray's max starting from (i)th idx in array of length 1)
    . . . . . . . .              (Level 1 - (i)th element represents subarray's max starting from (i)th idx in array of length 2)
    . . . . . .                  (Level 2 - (i)th element represents subarray's max starting from (i)th idx in array of length 4)
    . .                          (Level 3 - (i)th element represents subarray's max starting from (i)th idx in array of length 8)
    (You migh think: How it then decreased size with base 2 and not 1(As the elements choosen to find max on next level are such that they don't overlap and summing up gives maximum in twice size subarray))
    (i.e. why only array till (int)log2(size of array))-->(sparseMax[j][i] = Math.max(sparseMax[j - 1][i], sparseMax[j - 1][i + (1 << (j - 1)) , where j=level)
    Similarly for SparseMin array computing
    (e.g. arr={2,4,5,1}
          SparseMax={
            {2,4,5,1,9,6},
            {4,5,5,9,6},
            {5,9,9}
          }
    )

ii)Query( O(1) )
    Let's say for idx(2 to 4) 
    Get l=3(length of subarray)(Now we will act according to it starting from 2 and log2(3)=1)

    As each time we will not encounter base 2 length of subarray, so we will overlap some element from starting(2) and startingInRevers(4) to find maximum((2,3),(3,4))
    Incase if it's length is base 2, then they won't overlap

    -->( Math.max(sparseMax[j][L], sparseMax[j][R - (1 << j) + 1]), where j=level=log2(End-Start+1) )
    Similarly to get min in range
"""

from queue import PriorityQueue
class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        logs=[0,0]
        l=len(nums)
        for i in range(2,l+1):
            logs.append(logs[i>>1]+1)
        sparseMax=[[] for _ in range(l)]
        sparseMin=[[] for _ in range(l)]
        for i,j in enumerate(nums):
            sparseMax[i].append(j)
            sparseMin[i].append(j)
        for i in range(1,logs[-1]+1):
            span=1<<i
            half=1<<(i-1)
            for j in range(l-span+1):
                sparseMax[j].append(max(sparseMax[j][-1],sparseMax[j+half][-1]))
                sparseMin[j].append(min(sparseMin[j][-1],sparseMin[j+half][-1]))
        pq = PriorityQueue()
        for i in range(l):
            mn=min(sparseMin[i][logs[l-i]],sparseMin[l-(1<<logs[l-i])][logs[l-i]])
            mx=max(sparseMax[i][logs[l-i]],sparseMax[l-(1<<logs[l-i])][logs[l-i]])
            pq.put((mn-mx,(i,l-1)))
        ans=0
        while k>0:
            k-=1
            c, (l0,l1)=pq.get()
            ans-=c
            if l1>l0:
                mn=min(sparseMin[l0][logs[l1-l0]],sparseMin[l1-(1<<logs[l1-l0])][logs[l1-l0]])
                mx=max(sparseMax[l0][logs[l1-l0]],sparseMax[l1-(1<<logs[l1-l0])][logs[l1-l0]])
                pq.put((mn-mx,(l0,l1-1)))
        return ans