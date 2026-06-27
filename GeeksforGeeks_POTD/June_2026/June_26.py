"""
I did it with brute force maintaining the character occured if either appeared previously of matching with String2 to add it as another option to get selected for all indices of the character in String2
With this reaching last char with possible ways is the answer.

TC - O(n^2), SC - O(len(s2))

We can try other methods like:
1. Recursion - O(2^n)--> either skip or select the char if equal
2. Dynamic programming - O(n*m)--> Create 2D array(n*m), dp[i][j] represents number of ways selecting first 'j' in s2 in first 'i' in s1 filling with same logic if equal either skip or select
    (countWays) --- Done here(CODE)
"""

class Solution:
    def countWays(self, s1, s2):
        dp=[0]*(len(s2)+1)
        dp[0]=1
        for i in range(len(s1)):
            for j in range(len(s2),0,-1):
                if s1[i]==s2[j-1]:
                    dp[j]=(dp[j-1]+dp[j])%1000000007
        return dp[len(s2)]