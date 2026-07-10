"""
Whenever becomes equal take the maximum previous to it and then check for furhter-- Making partition by equal elements and choosing larger sum of part

TC - O(n), SC - O(1)
"""

class Solution:
    def maxPathSum(self, a, b):
        i=0
        j=0
        sum=0
        s1=0
        s2=0
        while i<len(a) and j<len(b):
            if a[i]<b[j]:
                s1+=a[i]
                i+=1
            elif a[i]>b[j]:
                s2+=b[j]
                j+=1
            else:
                sum+=max(s1,s2)+a[i]
                i+=1
                j+=1
                s1=s2=0
        while i<len(a): 
            s1+=a[i]
            i+=1
        while j<len(b): 
            s2+=b[j]
            j+=1
        sum+=max(s1,s2)
        return sum