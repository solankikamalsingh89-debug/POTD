'''
    We'll be having gcd always lesser than equal to minimum of both values.
    dp[i][j][k]=denotes number of ways seq1 with hcf (j), seq2 with hcf (k) within first i elements- in python we defined function for that(recursion) using memoization(@cache)
    Now iterate each element and update till i-th length by (i-1) and current element gcd - either choosing for seq1 or seq2 or for none
    Then finally at length (complete iteration), get sum of all such cases with equal gcd

    TC - O(n*(max_elemet)^2), SC - O((max_elemet)^2)
'''

class Solution:
    def subsequencePairCount(self, A: List[int]) -> int:
        N = len(A)
        MOD = 10**9+7
        @cache
        def dp(i, g1, g2):
            if i == N:
                return +(g1 == g2 > 0)
            g1n = gcd(g1, A[i])
            g2n = gcd(g2, A[i])
            return (dp(i+1, g1n, g2) + dp(i+1, g1, g2n) +  dp(i+1,g1,g2))%MOD

        return dp(0,0,0)%MOD