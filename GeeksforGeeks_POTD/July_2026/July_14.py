"""
Storing the minmum must value and as x depends on previous numbers so reverse traversal(to avoid multiple depency and work with threshold x only)
x at traversal point -- this should be atleast output- find the at least input

TC - O(n), SC - O(1)
"""

class Solution:
    def find(self, arr):
        x=0
        for i in reversed(arr):
            if x<i: x+=(i-x+1)//2
            else: x-=(x-i)//2
        return x