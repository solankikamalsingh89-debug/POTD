"""
BFS - If could reach destination , return true
TC - O(n*m), SC - O(n*m)

Further Optimization:
    Using arraydeque faster or also can use simple circular array implementation
    Making of Direction array ={0,1,0,-1,0} 
    If constraint are large then copy list in array exactly to avoid multiple boxing/unboxing
"""

class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        line=deque()
        m=len(grid)-1
        n=len(grid[0])-1;
        vis=[[0 for _ in range(n+1)] for _ in range(m+1)]
        k=grid[m][n]
        line.append((0,0,health))
        while line:
            a0,a1,a2=line.popleft()
            if a0<0 or a1<0 or a0>m or a1>n or a2<1+k: continue
            if vis[a0][a1]>=a2: continue
            if a0==m and a1==n: return True
            vis[a0][a1]=a2
            line.append((a0+1,a1,a2-grid[a0][a1]))
            line.append((a0-1,a1,a2-grid[a0][a1]))
            line.append((a0,a1+1,a2-grid[a0][a1]))
            line.append((a0,a1-1,a2-grid[a0][a1]))
        return False