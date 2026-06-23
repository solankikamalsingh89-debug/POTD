"""
Brute FOrce- Easy
"""

class Solution:
    def maxPeopleDefeated(self, p):
        k=0
        while p>=0:
            k+=1
            p-=k*k
        return k-1