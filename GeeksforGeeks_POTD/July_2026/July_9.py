"""
Make pairs for remainder
And for middle and rem=0--> act differently

TC - O(n), SC - O(k)
"""

class Solution:
    def countKdivPairs(self, arr, k):
        rem=[0]*k
        for i in arr:
            rem[i%k]+=1
        ans=(rem[0]*(rem[0]-1))//2;
        l=1
        h=k-1
        while l<h:
            ans+=rem[l]*rem[h]
            l+=1
            h-=1
        if l==h: ans+=(rem[l]*(rem[l]-1))//2;
        return ans