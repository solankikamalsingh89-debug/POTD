class Solution:
    dp=[[]]
	def shortestDist(self, mat):
	    n=len(mat)-1
		self.dp=[[False for _ in range(n+1)] for _ in range(n+1)]
        if mat[0][0]==0: return [[-1]]
        ans=[[0 for _ in range(n+1)] for _ in range(n+1)]
        if self.dfs(n,mat,ans,0,0): return ans
        return [[-1]]
    def dfs(self, n, mat, ans, i, j):
        if self.dp[i][j]: return False
        if i+j==2*n:
            ans[n][n]=1
            return True
        for k in range(mat[i][j]):
            if j+k<n and mat[i][j+k+1]!=0:
                if self.dfs(n, mat, ans, i, j+k+1):
                    ans[i][j]=1
                    return True
                else: self.dp[i][j+k+1]=True
            if i+k<n and mat[i+k+1][j]!=0:
                if self.dfs(n, mat, ans, i+k+1, j):
                    ans[i][j]=1
                    return True
                else: self.dp[i+k][j]=True
            if i+k>=n and j+k>=n:
                self.dp[i][j]=True
                return False
        self.dp[i][j]=True
        return False