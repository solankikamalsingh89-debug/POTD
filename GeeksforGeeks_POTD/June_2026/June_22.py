"""
Firstly tried brute force with O(n^2), get TLE(Finding all possible area values)
Later:
    Mark starting block index in ArrayList 'i', either 1st block or if maximum from front traversal
    Similarly mark ArrayList 'j' by back traversal

    Now looped over j(as removing from last done in O(1) without extra variable) nesting loop over i to find all possbile area under these blobk to get maxiimum area as answer

TC - O(n^2), SC - O(n)
"""

class Solution:
    def maxArea(self, height):
        l=len(height)
        ans=min(height[0],height[-1])*(l-2);
        i=[]
        mi=height[0]
        j=[]
        mj=height[-1]
        for k in range(l-2,1,-1):
            if height[k]>mj:
                mj=height[k]
                j.append(k)
                ans=max(ans,min(height[0],mj)*(k-1))
        for k in range(1,l-2):
            if height[k]>mi:
                mi=height[k]
                i.append(k)
                ans=max(ans,min(height[-1],mi)*(l-k-2))
        while j:
            j1=j.pop()
            k=0
            while k<len(i) and i[k]<j1-1:
                ans=max(ans,min(height[j1],height[i[k]])*(j1-i[k]-1))
                k+=1
        return ans