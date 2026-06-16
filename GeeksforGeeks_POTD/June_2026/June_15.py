"""
Maintain a array dp for storing minimum cost for weights lesser than w--use previous calculated cost to evsluate next dp element
To control -1 for no packet make it's cost very big(out of output from constraint), so that using this min price will bevery high(if this will be output , output -1)
TC - O(w^2), SC - O(w)
"""

class Solution:
    def minimumCost(self, cost, w):
        dp=[200001]*(w+1)
        dp[0]=0
        for i in range(1,w+1):
            for j in range(len(cost)):
                if cost[j]==-1: continue
                if i<j: break
                dp[i]=min(dp[i],dp[i-j-1]+cost[j])
        return -1 if dp[w]>=200001 else dp[w]