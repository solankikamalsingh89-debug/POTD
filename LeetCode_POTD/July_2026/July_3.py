"""
New Learning: Topological Sort( For DAG(Directed acyclic graphs) only) -- In this nodes are arranged such that children of any level will come after it for all elements
                    - Topo Sort: Start with nodes having no parent (adding them in queue), then follow each's children(decreement it's in_edges) and add in queue if for any in_edges become zero

After topological sort of nodes.
Create a list of all possible cost (As from these we will choose answer) in ascending order
Then with binary search technique check for each by function(ok) if it can be answer, if yes search in higher else in lower cost values

E=no. of edges, V= no. of vertices
TC - O(ElogE)+O(logE)×O(V+E) {Sort cost + Binary Search*ok function} = O(ElogE), SC - O(V+E) {Graph(V+E) + cost(E) + (topo_sort + DP(ok) + Queue + indegree)(V)}

"""

class Solution:
    def findMaxPathScore(self, edges: List[List[int]], online: List[bool], k: int) -> int:
        n = len(online)
        adj = [[] for I in range(n)]
        indeg = [0]*n
        vals = set()
        for u, v, c in edges:
            adj[u].append((v,c))
            indeg[v] += 1
            vals.add(c)

        # topo sort
        q = deque(i for i, d in enumerate(indeg) if d == 0)
        topo = []
        while q:
            u = q.popleft()
            topo.append(u)
            for v, _ in adj[u]:
                indeg[v] -= 1
                if indeg[v] == 0:
                    q.append(v)
        arr = sorted(vals)
        INF = float('inf')

        # check threshold feasible
        def ok(th):
            dp = [INF]*n
            dp[0] = 0
            for u in topo:
                if dp[u] > k or not online[u]:
                    continue
                for v, c in adj[u]:
                    if c < th or not online[v]:
                        continue
                    nc = dp[u] + c
                    if nc < dp[v]:
                        dp[v] = nc
            return dp[n-1] <= k

        ans = -1
        lo, hi = 0, len(arr)-1
        while lo <= hi:
            mid = (lo + hi) // 2
            if ok(arr[mid]):
                ans = mid
                lo = mid + 1
            else:
                hi = mid - 1

        return arr[ans] if ans >= 0 else -1