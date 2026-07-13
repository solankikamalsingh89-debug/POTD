"""
Simple question as in Maths 7th class book to get all runners on circular track meet again.
So find all circular steps and get all of their lcm. -- To avoid multiple times lcm for same circle, made a visited array

TC - O(n*log(n)){logn for worst case hcf}, SC - O(n)
"""

import math
class Solution:
    def minOperations(self, b):
        n=len(b)
        vis=[False]*n
        lcm=1
        for i in range(n):
            if not vis[i]:
                j=b[i]-1
                steps=1
                while j!=i:
                    vis[j]=True
                    j=b[j]-1
                    steps+=1
                lcm=math.lcm(lcm,steps)
        return lcm