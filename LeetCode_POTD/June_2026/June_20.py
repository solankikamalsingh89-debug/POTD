"""
hink restrictions mentioning height of i-th building be it's height actually.
Now lower the heights of restrictions so that it can be reached by its just neighbours(How will we check this-- by comparing steps we have(or distance between 2 restrictions) and their heights)
This will be first done from front traversal.
Now there is chance of some cases to be left to handle ( e.g. We decreased two restrictions simultaneously, then first decreased may have chance that now next restriction can't be reached with steps)-- So, a final check by back traversal with finding max height simultaneously(How height to be calculated?)
Height is calculated by steps(Left after maintaining both at least height of both)

TC - O(nlogn){Its beacuse of sorting array, otherwise trsversal is fdone in O(n)}, SC- O(1)
"""

class Solution:
    def maxBuilding(self, n: int, restrictions: List[List[int]]) -> int:
        l=len(restrictions)
        if l==0 : return n-1
        restrictions = sorted(restrictions, key=lambda x: x[0])
        ma=0
        steps=restrictions[0][0]-1-restrictions[0][1]
        if steps<0: restrictions[0][1]+=steps
        for i in range(1,l):
            if restrictions[i-1][1]>=restrictions[i][1]:
                steps=restrictions[i][0]-restrictions[i-1][0]-restrictions[i-1][1]+restrictions[i][1]
                if steps<0: restrictions[i-1][1]+=steps
            else:
                steps=restrictions[i][0]-restrictions[i-1][0]-restrictions[i][1]+restrictions[i-1][1]
                if steps<0: restrictions[i][1]+=steps
        for i in range (l-1,0,-1):
            if restrictions[i-1][1]>restrictions[i][1]:
                steps=restrictions[i][0]-restrictions[i-1][0]-restrictions[i-1][1]+restrictions[i][1]
                if steps<0:
                    restrictions[i-1][1]+=steps
                    ma=max(ma,restrictions[i-1][1])
                else:
                    ma=max(ma,restrictions[i-1][1]+(steps)//2)
            else:
                ma=max(ma,restrictions[i][1]+(restrictions[i][0]-restrictions[i-1][0]-restrictions[i][1]+restrictions[i-1][1])//2)
        ma=max(ma,restrictions[0][1]+(restrictions[0][0]-restrictions[0][1]-1)//2)
        return max(ma,n-restrictions[l-1][0]+restrictions[l-1][1])