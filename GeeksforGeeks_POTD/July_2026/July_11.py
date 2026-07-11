"""
Doing DFS for unvisited points in particular path(dfs) only to get maximum from all direction to pass previous dfs call

TC - O(4^nm), SC - O(nm)
"""

class Solution:
    def longestPath(self, mat, xs, ys, xd, yd):
        dir=[0,1,0,-1,0]
        if mat[xs][ys]+mat[xd][yd]<2: return -1
        n=len(mat)
        m=len(mat[0])
        vis=[[False for _ in range(m)] for _ in range(n)]
        def dfs(i,j):
            if i==xs and j==ys: return 0
            vis[i][j]=True
            mm=-1
            for k in range(4):
                i1=i+dir[k]
                j1=j+dir[k+1]
                if i1<n and i1>=0 and j1<m and j1>=0 and mat[i1][j1]==1 and not vis[i1][j1]: mm=max(mm,dfs(i1,j1))
            vis[i][j]=False
            if mm==-1: return mm
            return mm+1
        return dfs(xd,yd)