"""
Convert string to 2d array to make easy access
Use memoization to prevent TLE(DP) in dfs to search path with maintaining at each point, how many path for maximum scores are available

TC - O(n^2), SC - O(n^2)
"""

class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        n=len(board)
        memo=[[None] * n for _ in range(n)]
        chess = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            cur=board[i]
            for j in range(n):
                if cur[j]=='X': chess[i][j]=-1
                elif cur[j].isdigit():
                    chess[i][j] = int(cur[j])
        def dfs(chess, i, j):
            if i==0 and j==0:
                return [0,1]
            if i<0 or j<0 or chess[i][j]==-1: return [-100000,0]
            if memo[i][j] is not None: return memo[i][j]
            a=dfs(chess,i-1,j-1)
            b=dfs(chess,i-1,j)
            c=dfs(chess,i,j-1)
            m=max(a[0],b[0],c[0])
            w=0
            if a[0]==m: w+=a[1]
            if b[0]==m: w+=b[1]
            if c[0]==m: w+=c[1]
            memo[i][j]=[chess[i][j]+m,(w%1000000007)]
            return memo[i][j]
        ans=dfs(chess,n-1,n-1)
        if ans[0]<0:  return [0,0]
        return ans