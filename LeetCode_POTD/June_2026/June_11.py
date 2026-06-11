"""
Two main concerns in quetion:
1.Traversing whole tree to get max_height
2.By max_height find the number of ways weight is odd

1.We have 2 options:
i)DFS: (Done by Java Code)
    -I tried something similar firstly with HashMap(in place of array) of integer(node name) and its connected nodes(parent and children) as HashSet(in place of ArrayList)
     for O(n), O(1) was costing many operation like two removals if any edge is evaluated, multiple iterator for hashset each time
    -So later i switched to usual DFS to over come TLE(Array of arraylist for neighbours of node), also here i used parent to avoid back traversal
ii)BFS: (Done by Java Code)
    -Making a queue to maitain BFS starting from root(1) and their height with firstly setting up Array of arraylist for neighbours of node, then foing BFS to get max_depth at end

2.As number of 1 should be odd:
 nC1+nC3+nC5+..... all odd terms=> 2^(n-1)
"""

class Solution:
    def assignEdgeWeights(self, edges: List[List[int]]) -> int:
        max_depth=0
        l=len(edges)+1
        a=[[] for _ in range(l)]
        for i,j in edges:
            a[i-1].append(j-1)
            a[j-1].append(i-1)
        queue = deque()
        queue.append((0,0,-1))
        while queue:
            q0,q1,q2=queue.popleft()
            if len(a[q0])==1 and q0!=0: max_depth=max(max_depth,q1)
            else:
                for it in a[q0]: 
                    if it!=q2: queue.append((it,q1+1,q0))
        return (2**(max_depth-1))%1000000007