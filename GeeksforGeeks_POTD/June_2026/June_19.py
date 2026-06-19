"""
New Learning: Value for which minimum operation will be required is Median.

So traverse array and maintain index for values lesser than median. (As median can increase only- sorted array)
Maintain sum in 2 parts(less than median and greater than equal to median) to get how much operations are required to make all equal to median
TC - O(n), SC - O(1)
"""

class Solution:
    def optimalArray(self, arr):
        l=len(arr)
        ans=[None]*l
        lsum=arr[0]
        hsum=0
        lidx=1 #Less than it in lsum
        ans[0]=0
        j=1
        while lidx<l and arr[lidx]==arr[lidx-1]:
            ans[j]=0
            j+=1
            lsum+=arr[0]
            lidx+=1
        for i in range(lidx,l):
            avg=(arr[(i+1)//2]+arr[i//2])//2
            hsum+=arr[i]
            while arr[lidx]<avg:
                lsum+=arr[lidx]
                hsum-=arr[lidx]
                lidx+=1
            ans[j]=hsum-(avg*(i-lidx+1))-lsum+(avg*lidx)
            j+=1
        return ans