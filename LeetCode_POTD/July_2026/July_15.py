"""
(2n-1),2n--> Differnce in sum = n, sum of first even=n(n+1), first odd=n*n
GCD(n*n+n,n*n)=GCD(n*n,n)=n

TC - O(1), SC -O(1)
"""

class Solution:
    def gcdOfOddEvenSums(self, n: int) -> int:
        return n