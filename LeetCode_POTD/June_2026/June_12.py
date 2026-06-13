"""
As there are multiple different queries we have to optimize the way to find distance between 2 nodes of query -> Lowest Common Ancestor(Binary Lifting)( O(logn) per query, processing time O(nlogn) )
To prevent stack overflow for skewed tree cases- we prefer BFS over DFS
1. Building Tree: (O(nlogn))
    Make arraylist for adjacent nodes of each node
    Using Queue traverse BFS starting by Node 1 with mentioning depth of node in array depth
    Define LOG for maximum size of ancestors going up on base 2(not mentioning each node)--> up[n+1][LOG]
    up[node'val][ancestor no.] (If ancestor no. = 0 -> 1 step up, 1 -> 2 step up, 2 -> 4 step up ...) (up[node][j] =up[up[node][j - 1]][j - 1], j=ancestor no.)
2. Resolving Query: O(logn)
    Pass (dist-1) between node in solvex function to get answer(2^(dist-1)%1_000_000_007)
    How to get dist:
        Firstly find differnce in depth, then make both at same depth(min of both node's depth)-> To make depth equal use binary system to update node
        Then from the top(root), check with decreasing ancestor no. to react lowest commmon ancestror(if different ancestor then , safe to move upward)

"""

class Solution:
    def assignEdgeWeights(self, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        n=len(edges)+1
        LOG=1
        depth=[0]*(n+1)
        while 1<<LOG<=n: LOG+=1
        up=[[0 for _ in range(LOG)] for _ in range(n+1)]
        adj=[[] for _ in range(n+1)]
        for i,j in edges:
            adj[i].append(j)
            adj[j].append(i)
        queue=deque()
        queue.append(1)
        depth[1]=0
        up[1][0]=1
        vis=[False]*(n+1)
        vis[1]=True
        while queue:
            i=queue.popleft()
            for j in adj[i]:
                if not vis[j]:
                    queue.append(j)
                    depth[j]=depth[i]+1
                    up[j][0]=i
                    vis[j]=True
        for i in range(1,LOG):
            for j in range(1,n+1):
                up[j][i]=up[up[j][i-1]][i-1]

        MOD = 1000000007
        pow2 = [1] * n
        for i in range(1, n):
            pow2[i] = (pow2[i - 1] * 2) % MOD

        ans=[]
        for i,j in queries:
            dist=depth[i]+depth[j]
            if depth[i]<depth[j]:
                i,j=j,i
            diff=depth[i]-depth[j]
            k=0
            while 1<<k <= diff:
                if diff&(1<<k)!=0:
                    i=up[i][k]
                k+=1
            if i==j: dist-=2*depth[i]
            else:
                for o in range(LOG-1,-1,-1):
                    if up[i][o]!=up[j][o]:
                        i=up[i][o]
                        j=up[j][o]
                dist-=2*depth[up[i][0]]
            if dist <= 0:
                ans.append(0)
            else:
                ans.append(pow2[dist - 1])
        return ans