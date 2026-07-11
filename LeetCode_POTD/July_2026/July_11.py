"""
Create the graph adjacency list and then for each if have not been visited yet, traverse complete connected subgraph and check if all nodes were having (subgraph size)-1 edges to ensure completeness

TC - O(n), SC - O(n)
"""

class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        edg=[0]*n
        adj=[[] for _ in range(n)]
        for i,j in edges:
            adj[i].append(j)
            adj[j].append(i)
            edg[i]+=1
            edg[j]+=1
        ans=0
        l=deque()
        vis=[False]*n
        for i in range(n):
            if not vis[i]:
                flg=True
                cnt=edg[i]-1
                vis[i]=True
                for j in adj[i]: l.append(j)
                while l:
                    a=l.popleft()
                    if vis[a]: continue
                    vis[a]=True
                    if cnt<0 or edg[i]!=edg[a]: 
                        flg=False
                    cnt-=1
                    for j in adj[a]: l.append(j)
                if flg: ans+=1
        return ans