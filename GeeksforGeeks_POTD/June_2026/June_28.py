"""
dp[j][0] represents choosing this node as 0, number of ways exist for length '_' with 'j' adjacent 1 pairs
So, intitalize with length 1 having 1-1 cases for both 0 and 1 with 0 adjacent pairs
Then iterate over full dp -> 
    Initialize for both 0 and 1 with length 'i'
    And add according to previous cases 

TC - O(n*m), SC - O(m)
"""

class Solution:
    def countStrings(self, n, k):
        MODULO = 10**9 + 7
        dp = [[0, 0] for _ in range(k + 1)]
        dp[0][0] = dp[0][1] = 1
        for _ in range(n - 1):
            for i in reversed(range(1, k + 1)):
                dp[i][0], dp[i][1] = (dp[i][0] + dp[i][1]) % MODULO, (dp[i][0] + dp[i - 1][1]) % MODULO
            dp[0][0], dp[0][1] = (dp[0][0] + dp[0][1]) % MODULO, dp[0][0]
        return sum(dp[k]) % MODULO