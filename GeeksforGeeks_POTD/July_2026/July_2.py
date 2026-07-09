"""
Maitained a boolean array of k-size to maintain record of remainder of sum we have by elements till iterated
(Whatever sum has acheived earlier - add new element to mark new element arriving)
-Can also do the same with recurion as well

TC - O(n*k), SC - O(k)
"""

class Solution:
    def divisibleByK(self, arr, k):
        dp = [[False] * k for _ in range(len(arr) + 1)]
        dp[0][0] = True
        for i, v in enumerate(arr):
            for j in range(k):
                if dp[i][j]:
                    dp[i+1][j] = True
                    rem = (j + v) % k
                    if rem == 0:
                        return True
                    dp[i+1][rem] = True
        return False