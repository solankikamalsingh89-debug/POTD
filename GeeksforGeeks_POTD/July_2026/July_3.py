"""
Just check the reachability by tower p and q seperately. Then find their intersection

TC - O(nm), SC - O(nm)
"""

class Solution:
    def countCoordinates(self, mat):
        m = len(mat)
        n = len(mat[0])
    
        p_queue = []
        q_queue = []
        
        for i in range(m):
            p_queue.append((i,0))
            q_queue.append((i,n-1))
        
        for i in range(n):
            p_queue.append((0,i))
            q_queue.append((m-1,i))
        
        
        def tower_reach_by_station(queue, visit):
            
            while queue:
                r,c = queue.pop(0)
                if (r,c) in visit:
                    continue
                
                visit.add((r,c))
                
                for dr,dc in [(0,1), (0,-1), (1,0), (-1,0)]:
                    nr,nc = dr+r, dc+c
                    if (nr, nc) not in visit and 0 <= nr < m and 0<= nc < n and mat[nr][nc] >= mat[r][c]:
                        queue.append((nr,nc))
            
            return visit
        
        
        tower_reach_by_p = tower_reach_by_station(p_queue, set())
        tower_reach_by_q = tower_reach_by_station(q_queue, set())

        return len(tower_reach_by_p.intersection(tower_reach_by_q))