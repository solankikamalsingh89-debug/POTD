"""
Take maximum number of 3 with remaining 2 only.
(As 6=(2*2*2=8),(3*3=9))--Similarly for others
"""

class Solution:
    def maxProduct(self, n):
        if n==2: return 1
        if n==3: return 2
        if n%3==1: return ((3**((n-4)//3))*4)
        elif n%3==2:return ((3**((n-2)//3))*2)
        return (3**(n//3))