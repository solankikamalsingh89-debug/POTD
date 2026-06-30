"""
I can be done with 2^n choosing either multiplying with 0 or next b's element
So to optimize it I tried with dot[i][j] showing till length 'i' of 'a', we have used 'j' zeroes in multiplication and value represents maximum value attained in so
To optimize more (Memory)- 2D to 1D array

TC - O(n*(n-m)), SC - O(n)
"""

class Solution:
    def maxDotProduct(self, a, b):
        n = len(a)
        m = len(b)
        dp = {}
        def dotProduct(left, right, count):
            if (left, right, count) in dp:
                return dp[(left, right, count)]
            if right >= m:
                return 0
            if count == 0:
                prodSum = 0
                while left < n and right < m:
                    prodSum += a[left]*b[right]
                    left += 1
                    right += 1
                return prodSum
            # take 0 
            take = dotProduct(left+1, right, count-1)
            # dont take 0
            nottake = a[left]*b[right] + dotProduct(left+1, right+1, count) 
            dp[(left, right, count)] = max(take, nottake)
            return dp[(left, right, count)]
        return dotProduct(0,0,n-m)