"""
Storing minimum cost from all nodes with making adjacency list for graph
Then traverse BFS on graph till all nodes get as leaf- and each time maintain minimum of all

TC - O(n), SC - O(n)
"""

class Solution(object):
    def minScore(self, n, roads):
        adj = [[] for i in range(n)]
        dist = [10 ** 6] * n
        
        for u,v,w in roads:
            u -=1; v-=1
            
            dist[u] = min(dist[u], w)
            
            adj[u].append(v)
            adj[v].append(u)
            
        seen = [False] * n
        
        q = [0]
        seen[0] = 1
        
        while q:
            u = q.pop()
            for v in adj[u]:
                if not seen[v]:
                    seen[v] = 1
                    q.append(v)
                    
        best = 10 ** 6
        for i in range(n):
            if seen[i]:
                best = min(best, dist[i])
                
        return best
        